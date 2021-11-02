package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @GetMapping("/hello")           //<-- address you type in the browser after localhost8080
    @ResponseBody
    public String returnHello(){
        return "hello world";
    }

    @GetMapping("/howdy")
    @ResponseBody
    public String returnHowdy(){
        return "<h1>Howdy</h1>";
    }
}
