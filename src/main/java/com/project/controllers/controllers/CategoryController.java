package com.project.controllers.controllers;

import com.project.controllers.dao.ICategoryRepository;
import com.project.controllers.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/new")
    public String displayNewCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "category/new-category";
    }

    @PostMapping("/save")
    public String createCategory(Category category, Model model) {
        categoryRepository.save(category);

        return "redirect:/category/new";
    }

}
