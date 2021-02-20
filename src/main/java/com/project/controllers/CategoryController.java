package com.project.controllers;

import com.project.dao.ICategoryRepository;
import com.project.dao.IUserAccountRepository;
import com.project.entities.Category;
import com.project.entities.Content;
import com.project.entities.UserAccount;
import com.project.services.CategoryService;
import com.project.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.sound.midi.SysexMessage;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ContentService contentService;

    @Autowired
    IUserAccountRepository userAccountRepository;

    @GetMapping("/edit")
    public String displayEditCategoryForm(Model model, Principal principal) {
        Category category = new Category();
        model.addAttribute("category", category);

        List<Category> categories = categoryService.getUsersCategories(principal.getName());
        model.addAttribute("categories", categories);

        return "category/edit-category";
    }

    @PostMapping("/save")
    public String createCategory(Category category, Long id, Principal principal) {

        if (id != null) {
            category.setId(id);
        }

        UserAccount userAccount = userAccountRepository.findUserAccountByUserName(principal.getName());

        if (category.getUserAccountList() == null || !category.getUserAccountList().contains(userAccount)) {
            category.setUserAccountList(userAccount);
        }

        // TODO: Reassign the category to the contents

        categoryService.save(category);

        return "redirect:/category/edit";
    }

    @GetMapping("/edit/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Category category = categoryService.findCategoryById(id);

        if(category != null) {

            model.addAttribute("category", category);

            return "category/update-category";
        }
        return "redirect:/category/edit";
    }

    @GetMapping("/edit/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        Category category = categoryService.findCategoryById(id);
        if(category != null) {
            categoryService.deleteById(id);
        }
        return "redirect:/category/edit";
    }

}
