package com.project.controllers;

import com.project.entities.Category;
import com.project.entities.UserAccount;
import com.project.services.CategoryService;
import com.project.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    @Autowired
    UserAccountService userAccountService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    BCryptPasswordEncoder bCryptEncoder;

    @GetMapping("/register")
    public String register(Model model) {
        UserAccount userAccount = new UserAccount();
        model.addAttribute("userAccount", userAccount);

        return "security/register";
    }

    @PostMapping("/register/save")
    public String saveUser(Model model, UserAccount user) {
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        userAccountService.save(user);

        UserAccount user1 = userAccountService.findUserAccountByUserName(user.getUserName());
        // TODO: Add 4 Initial Categories for the user
        Category category = new Category("MyFirstCategory", user);
        categoryService.save(category);

        return "redirect:/";
    }
}
