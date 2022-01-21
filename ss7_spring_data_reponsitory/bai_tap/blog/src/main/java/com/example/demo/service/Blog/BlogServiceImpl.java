package com.example.demo.service.Blog;

import com.example.demo.model.Blog;
import com.example.demo.reponsitory.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;


    @Override
    public Optional<Blog> findById(Integer id) {
        Optional<Blog> blog = iBlogRepository.findById(id);
        return blog;
    }

    @Override
    public void delete(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);

    }

    @Override
    public Page<Blog> findByTitleContaining(String name, Pageable pageable) {
       return iBlogRepository.findByTitleContaining(name, pageable);
    }

    @Override
    public Page<Blog> findAll(Pageable page) {
        return iBlogRepository.findAll(page);
    }


}
