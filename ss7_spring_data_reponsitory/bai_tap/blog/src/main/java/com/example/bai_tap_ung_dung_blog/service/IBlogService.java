package com.example.bai_tap_ung_dung_blog.service;



public interface IBlogService {
    Blog findById(Long id);

    void delete(Long id);

    void save(Blog blog);

    void update(Long id);

    List<Blog> showALL();
}
