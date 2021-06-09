package com.cinema.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @RequestMapping("/home")
    public String getHomePage(){
        return "home";
    }

    @RequestMapping("/news")
    public String getNewsPage(){
        return "news";
    }

    @RequestMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    //public String
}
