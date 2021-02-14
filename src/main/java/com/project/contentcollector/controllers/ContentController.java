package com.project.contentcollector.controllers;

import com.project.contentcollector.dao.ICategoryRepository;
import com.project.contentcollector.dao.IContentRepository;
import com.project.contentcollector.entities.Category;
import com.project.contentcollector.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

}
