package app.reponsitory;

import app.model.Blog;

import java.util.List;

public interface IBlogReponsitory {
    Blog findById(Long id);

    void delete(Long id);

    void save(Blog blog);

    void update(int id);

    List<Blog> showAll();
}
