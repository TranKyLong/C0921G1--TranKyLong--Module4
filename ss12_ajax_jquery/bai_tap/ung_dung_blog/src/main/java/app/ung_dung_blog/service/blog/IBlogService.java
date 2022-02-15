package app.ung_dung_blog.service.blog;

import app.ung_dung_blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    List<Blog> getAllBlog(int number);

    List<Blog> getDetailById(Integer id);

    List<Blog> getAllByCategory(Integer id);

    void save(Blog blog);

    void delete(Integer id);

    List<Blog>findByName(String name);

}
