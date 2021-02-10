package com.project.contentcollector.controllers;

import com.project.contentcollector.dao.IContentRepository;
import com.project.contentcollector.entities.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    IContentRepository contentRepository;

    @GetMapping("/")
    public String displayHome(Model model) {

        // Returns all the content in the DB
        List<Content> content = contentRepository.findAll();
        model.addAttribute("content", content);

        return "home/home";
    }
}
