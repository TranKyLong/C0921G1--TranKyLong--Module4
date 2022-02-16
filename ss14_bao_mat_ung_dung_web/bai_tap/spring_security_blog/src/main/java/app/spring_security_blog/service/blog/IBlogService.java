package app.spring_security_blog.service.blog;

import app.spring_security_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void delete(Integer id);

    void save(Blog blog);

}
