package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {

    @GetMapping("/ads")
    @ResponseBody
    public String showAds(){
        return "showing all the ads";
    }

    //path variable
    @GetMapping("/ads/{id}")
    @ResponseBody
    public String showSingleAd(@PathVariable long id){          //this is to pull out an id from an ad {id} is whatever we put in
        return "showing ad: " + id;
    }

    @PostMapping("/ads")
    @ResponseBody
    public String createAd(){
        return "creating an ads";
    }


    //path variables are what we can add in the url and get them and use them to add info to page
    @GetMapping("/color/{color}")
    @ResponseBody
    public String returnColor(@PathVariable String color){
        return "<h1 style='color: "+ color + "'>" + color + "</h1>";
    }


    //shows how we can add styling
    @GetMapping("/bg/{color1}/font/{color2}")
    @ResponseBody
    public String returnBgFontColor(@PathVariable String color1, @PathVariable String color2){
        return String.format("<h1 style='background-color:%s;color:%s'>%s</h1>", color1, color2, color2);
    }

    //adds a default value, also how you pull out form inputs
    @GetMapping("/name")
    @ResponseBody
    public String returnName(@RequestParam(defaultValue = "Hello world") String n){        //requesting a variable in the query
        return "Returning name: " + n;
    }

}
