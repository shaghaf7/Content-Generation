package com.example.BlogApp.controller;

import com.example.BlogApp.entity.Blog;
import com.example.BlogApp.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    // CREATE BLOG
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogService.createBlog(blog);
    }

    // GET ALL BLOGS
    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAllBlogs();
    }

    // GET SINGLE BLOG
    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable Long id) {
        return blogService.getBlogById(id);
    }

    // UPDATE BLOG
    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
        return blogService.updateBlog(id, blog);
    }

    // DELETE BLOG
    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "Blog deleted successfully";
    }
}
