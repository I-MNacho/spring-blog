package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostImage;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {


    private PostRepository postsDAO;
    private UserRepository usersDao;

    public PostController(PostRepository postsDAO, UserRepository usersDao) {
        this.postsDAO = postsDAO;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        //fetch posts with postsDao
        List<Post> posts = postsDAO.findAll();
        //send a list of post objects to index view
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "Returning post for user: " + id;
    }

    @GetMapping("/posts/create")
    public String create(){
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String insert(@RequestParam String title, @RequestParam String body, @RequestParam List<String> urls){

        List<PostImage> images = new ArrayList<>();
        User author = usersDao.getById(1L);
        Post post = new Post(title, body);

        //create list of post image objects to pass to the new post constructor
        for (String url : urls){
            PostImage postImage = new PostImage(url);
            postImage.setPost(post);
            images.add(postImage);
        }

        post.setImages(images);

        post.setUser(author);

    //save a post object with images
    postsDAO.save(post);

    //modify the post index view to display post images
    return "redirect:/posts";
    }



    //========================= EDIT
    //add an end point to send the user an edit post form / view
    //create an edit post form
    //create another endpoint to handle the ost request of editing a post

    //send user to edit post form
    @GetMapping("/posts/{id}/edit")
    public String returnEditView(@PathVariable long id, Model viewModel){
        //send an edit form to user
        viewModel.addAttribute("post", postsDAO.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String updatePost(@PathVariable long id, @RequestParam(name="title") String title, @RequestParam String body){
        //use the new form inputs to update the existing post in the DB
        //pull the existing post object from the database
        Post post = postsDAO.getById(id);

        //set the title and body to the request param values
        post.setTitle(title);
        post.setBody(body);

        //persist the change in the db with the postsDao
        postsDAO.save(post);        //works to both update and insert

        return "redirect:/posts";
    }

    //delete logic to delete correct posts
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id){
        postsDAO.deleteById(id);
        return "redirect:/posts";
    }

}
