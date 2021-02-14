package com.project.controllers.controllers;

import com.project.controllers.dao.ICategoryRepository;
import com.project.controllers.dao.IContentRepository;
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
@RequestMapping("/content")
public class ContentController {

    @Autowired
    // Creates an instance of an anon class
    IContentRepository contentRepository;

    @Autowired
    ICategoryRepository categoryRepository;

    @GetMapping("/new")
    public String displayContentForm(Model model) {
        // Use model to bind HTML and Java code
        Content content = new Content();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("content", content);
        model.addAttribute("categories", categories);
        return"content/new-content";
    }

    @PostMapping("/save")
    public String createContent (Content content, Model model) {
        // Handles saving content to DB
        contentRepository.save(content);

        // Can use a redirect to prevent duplicate submissions - url redirect, redirects to controller
        return "redirect:/content/new";
    }

    @GetMapping("/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Optional<Content> content = contentRepository.findById(id);
        if(content != null) {
            model.addAttribute("content", content);

            List<Category> categories = categoryRepository.findAll();
            model.addAttribute("categories", categories);

            return "content/new-content";
        }
        return "redirect:/";
    }

}
