package com.project.controllers;

import com.project.dao.ICategoryRepository;
import com.project.entities.Category;
import com.project.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/edit")
    public String displayEditCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        return "category/edit-category";
    }

    @PostMapping("/save")
    public String createCategory(Category category, Long id) {
        if (id != null) {
            category.setId(id);
        }

        categoryService.save(category);

        return "redirect:/category/edit";
    }

    @GetMapping("/edit/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id).get();
        if(category != null) {
            model.addAttribute("category", category);

            return "category/update-category";
        }
        return "redirect:/category/edit";
    }

    @GetMapping("/edit/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if(category != null) {
            categoryService.deleteById(id);
        }
        return "redirect:/category/edit";
    }

}
