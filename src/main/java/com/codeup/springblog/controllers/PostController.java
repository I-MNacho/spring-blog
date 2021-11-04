package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {


    private PostRepository postsDAO;

    public PostController(PostRepository postsDAO) {
        this.postsDAO = postsDAO;
    }

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        //seed posts in the DB
        //fetch ppsts with postsDao
        //create a posts index view
        //send a list of post objects to index view
        return "Returning all posts";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
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

    //add an end point to send the user an edit post form / view
    //create an edit post form
    //create another endpoint to handle the ost request of editing a post

}
