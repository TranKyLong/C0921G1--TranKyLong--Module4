package app.ung_dung_blog.service.blog;

import app.ung_dung_blog.model.Blog;
import app.ung_dung_blog.reponsitory.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public List<Blog> getAllBlog(int number) {
        return iBlogRepository.getBlogList(number);
    }

    @Override
    public List<Blog> getDetailById(Integer id) {
        return iBlogRepository.getBlogDetailById(id);
    }

    @Override
    public List<Blog> getAllByCategory(Integer id) {
        return iBlogRepository.getBlogListById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return iBlogRepository.findAllByTitleContaining(name);
    }
}
