package com.project.controllers;

import com.project.dao.IContentRepository;
import com.project.dao.IUserAccountRepository;
import com.project.entities.Content;
import com.project.entities.UserAccount;
import com.project.services.ContentService;
import com.project.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Value("${version}")
    private String ver;

    @Autowired
    ContentService contentService;

    @Autowired
    UserAccountService userAccountService;

    @GetMapping("/")
    public String displayHome(Model model, Principal principal) {

        model.addAttribute("versionNumber", ver);

        UserAccount user = userAccountService.findUserAccountByUserName(principal.getName());
        List<Content> content = contentService.findContentsByUser(user);

        model.addAttribute("content", content);

        return "home/home";
    }
}
