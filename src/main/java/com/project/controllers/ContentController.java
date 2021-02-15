package com.project.controllers;

import com.project.dao.ICategoryRepository;
import com.project.dao.IContentRepository;
import com.project.entities.Category;
import com.project.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "content/new-content";
    }

    @PostMapping("/save")
    public String createContent (@ModelAttribute Content content, Long id) {

        if (id != null) {
            content.setId(id);
        }

        // Handles saving content to DB
        contentRepository.save(content);

        // Can use a redirect to prevent duplicate submissions - url redirect, redirects to controller
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editContent(@PathVariable Long id, Model model) {
        Content content = contentRepository.findById(id).get();
        if(content != null) {
            model.addAttribute("content", content);

            List<Category> categories = categoryRepository.findAll();
            model.addAttribute("categories", categories);

            return "content/new-content";
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteContent(@PathVariable Long id) {
        Optional<Content> content = contentRepository.findById(id);
        if(content != null) {
            contentRepository.deleteById(id);
        }
        return "redirect:/";
    }

}
