package com.example.demo.service;

import com.example.demo.model.Blog;

import java.util.Optional;

public interface IBlogService {

    Optional<Blog> findById(Integer id);

    void delete(Integer id);

    void save(Blog blog);

    void update(Integer id);

    Iterable<Blog> showALL();
}
