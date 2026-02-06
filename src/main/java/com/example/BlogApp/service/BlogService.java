package com.example.BlogApp.service;

import com.example.BlogApp.entity.Blog;
import com.example.BlogApp.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public Blog createBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog getBlogById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blog not found"));
    }

    public Blog updateBlog(Long id, Blog updatedBlog) {
        Blog blog = getBlogById(id);
        blog.setTitle(updatedBlog.getTitle());
        blog.setContent(updatedBlog.getContent());
        return blogRepository.save(blog);
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
