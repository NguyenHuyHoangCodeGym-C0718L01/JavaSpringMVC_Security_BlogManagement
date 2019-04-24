package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Post;
import com.codegym.service.CategoryService;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> findAllCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/create-blog")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-blog")
    public ModelAndView saveBlog(@ModelAttribute("post") Post post){
        postService.save(post);

        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping("/blog")
    public ModelAndView listBlogs(){
        Iterable<Post> list = postService.findAll();
        ModelAndView modelAndView = new ModelAndView("/post/list");
        modelAndView.addObject("posts", list);
        return modelAndView;
    }

    @GetMapping("/edit-blog/{id}")
    public ModelAndView showEditForm(@PathVariable int id){
        Post post = (Post) postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-blog")
    public ModelAndView updateBlog(@ModelAttribute("post") Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-blog/{id}")
    public ModelAndView showDeleteForm(@PathVariable int id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-blog")
    public String deleteBlog(@ModelAttribute("post") Post post){
        postService.remove(post.getId());
        return "redirect:blog";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage() {
        return "/accessDenied";
    }
}
