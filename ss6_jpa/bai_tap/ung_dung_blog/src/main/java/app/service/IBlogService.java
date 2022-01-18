package app.service;

import app.model.Blog;

import java.util.List;

public interface IBlogService {
    Blog findById(Long id);

    void delete(Long id);

    void save(Blog blog);

    void update(Long id);

    List<Blog> showALL();
}
