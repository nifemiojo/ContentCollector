package com.project.contentcollector.controllers;

import com.project.contentcollector.dao.IContentRepository;
import com.project.contentcollector.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    // Creates an instance of an anon class
    IContentRepository contentRepository;

    @GetMapping("/new")
    public String displayContentForm(Model model) {
        // Use model to bind HTML and Java code
        Content content = new Content();
        model.addAttribute("content", content);
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
