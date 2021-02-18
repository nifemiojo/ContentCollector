package com.project.controllers;

import com.project.entities.UserAccount;
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
    UserAccountService accountService;

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
        System.out.println(user.getUserName());
        user.setPassword(bCryptEncoder.encode(user.getPassword()));
        System.out.println(user.getUserName());
        accountService.save(user);
        return "redirect:/";
    }
}
