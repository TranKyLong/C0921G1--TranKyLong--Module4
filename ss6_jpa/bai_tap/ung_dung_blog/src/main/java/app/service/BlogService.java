package app.service;

import app.model.Blog;
import app.reponsitory.IBlogReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {


    @Autowired
    IBlogReponsitory songReponsitory;

    @Override
    public List<Blog> showALL() {
        return songReponsitory.showAll();
    }

    @Override
    public Blog findById(Long id) {
        return songReponsitory.findById(id);
    }

    @Override
    public void delete(Long id) {
        songReponsitory.delete(id);
    }

    @Override
    public void save(Blog blog) {
        songReponsitory.save(blog);
    }

    @Override
    public void update(Long id) {

    }


}
