package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.repositories.AdRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdController {

    private final AdRepository adRepository;                    //we created a field, then we use it to grab info from somewhere else, in this case, the adRepository

    public AdController(AdRepository adRepository) {            //dependency injection, injecting it
        this.adRepository = adRepository;
    }

    @GetMapping("/ads")
    @ResponseBody
    public List<Ad> showAds(){
        return  adRepository.findAll();  //created the adRepository in line 16. and then called upon it here with a findAll() method
    }

    //path variable
    @GetMapping("/ads/id/{id}")
    @ResponseBody
    public String showSingleAd(@PathVariable long id){          //this is to pull out an id from an ad {id} is whatever we put in
        return "showing ad: " + id;
    }


    @GetMapping("/ads/title/{title}")                             //get an Ad based on title
    @ResponseBody
    public Ad getByTitle(@PathVariable String title){
        return adRepository.findByTitle(title);
    }

    @GetMapping("/ads/descr/{descr}")                             //get an Ad based on description
    public Ad getByDescription(@PathVariable String descr){
        return adRepository.findByDescription(descr);
    }

    @GetMapping("/ads/titlePart/{titlePart}")                             //get an Ad based on title with a specific letter
    public List<Ad> getByTitlePart(@PathVariable String titlePart){
        return adRepository.findByTitleLike(titlePart);
    }

//    @PostMapping("/ads")
//    @ResponseBody
//    public String createAd(){
//        return "creating an ads";
//    }


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

    //accessing the adRepository that was created on line 15.
    @PostMapping("/ads")
    @ResponseBody
    public String createAd(@RequestBody Ad newAd){
        adRepository.save(newAd);
        return String.format("Ad created with an Id");
    }

}
