package com.coderbd.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping(value = "/")
    public String displayHi(){
        return "Simple Poll API v.1.0";
    }
}
