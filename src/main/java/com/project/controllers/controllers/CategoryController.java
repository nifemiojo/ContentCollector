package com.project.controllers.controllers;

import com.project.controllers.dao.ICategoryRepository;
import com.project.controllers.entities.Category;
import com.project.controllers.entities.Content;
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
    ICategoryRepository categoryRepository;

    @GetMapping("/edit")
    public String displayEditCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);

        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "category/edit-category";
    }

    @PostMapping("/save")
    public String createCategory(Category category, Model model) {
        categoryRepository.save(category);

        return "redirect:/category/edit";
    }

    @GetMapping("/edit/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category != null) {
            model.addAttribute("category", category);

            return "category/update-category";
        }
        return "redirect:/category/edit";
    }

    @GetMapping("/edit/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if(category != null) {
            categoryRepository.deleteById(id);
        }
        return "redirect:/category/edit";
    }

}
