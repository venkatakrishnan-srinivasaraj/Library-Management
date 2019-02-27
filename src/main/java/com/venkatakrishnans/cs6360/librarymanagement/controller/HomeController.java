package com.venkatakrishnans.cs6360.librarymanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"","/", "/checkin","/fine","/borrowerManagement"})
    public String home(){
        return "index";
    }
}
