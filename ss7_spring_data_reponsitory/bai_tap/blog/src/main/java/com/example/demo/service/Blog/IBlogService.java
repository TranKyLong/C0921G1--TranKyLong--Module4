package com.example.demo.service.Blog;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBlogService {

    Optional<Blog> findById(Integer id);

    void delete(Integer id);

    void save(Blog blog);

    Page<Blog> findByTitleContaining(String name,Pageable pageable);

    Page<Blog> findAll(Pageable page);
}
