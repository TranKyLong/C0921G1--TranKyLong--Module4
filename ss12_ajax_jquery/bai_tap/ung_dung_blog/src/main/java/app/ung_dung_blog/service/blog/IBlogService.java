package app.ung_dung_blog.service.blog;

import app.ung_dung_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> getAllBlog();

    List<Blog> getDetailById(Integer id);

    List<Blog> getAllByCategory(Integer id);

    void save(Blog blog);

    void delete(Integer id);

}
