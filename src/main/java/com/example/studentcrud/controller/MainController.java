package com.example.studentcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/index.html")
    public String showHomePage() {
        return "index";
    }
}
