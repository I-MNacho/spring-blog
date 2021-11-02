package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


    @GetMapping("/posts")
    @ResponseBody
    public String allPosts(){
        return "Returning all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable String id){
        return "Returning post for user: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String formForPost(){
        return "Returning form for create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String newPostCreate(){
        return "creating new post...";
    }


}
