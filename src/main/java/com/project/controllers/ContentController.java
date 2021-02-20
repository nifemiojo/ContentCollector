package com.project.controllers;

import com.project.dao.ICategoryRepository;
import com.project.entities.Category;
import com.project.entities.Content;
import com.project.services.CategoryService;
import com.project.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    // Creates an instance of an anon class
    ContentService contentService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/new")
    public String displayContentForm(Model model, Principal principal) {
        // Use model to bind HTML and Java code
        Content content = new Content();

        List<Category> categories = categoryService.getUsersCategories(principal.getName());

        model.addAttribute("content", content);
        model.addAttribute("categories", categories);
        return "content/new-content";
    }

    @PostMapping("/save")
    public String createContent (@ModelAttribute Content content, Long id, Principal principal) {

        if (id != null) {
            content.setId(id);
        }
        // Handles saving content to DB
        contentService.save(content, principal.getName());

        // Can use a redirect to prevent duplicate submissions - url redirect, redirects to controller
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContent(@PathVariable Long id, Model model, Principal principal) {
        Content content = contentService.findById(id).get();
        if(content != null) {
            model.addAttribute("content", content);

            List<Category> categories = categoryService.getUsersCategories(principal.getName());

            model.addAttribute("categories", categories);

            return "content/new-content";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContent(@PathVariable Long id, Principal principal) {
        // TODO : Need a check that the content belongs to the user before delete

        Optional<Content> content = contentService.findById(id);
        if(content != null) {
            contentService.deleteById(id);
        }
        return "redirect:/";
    }

}
