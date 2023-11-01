package com.project.PlatformUM.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;


@RestController

public class AppController {

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

}
