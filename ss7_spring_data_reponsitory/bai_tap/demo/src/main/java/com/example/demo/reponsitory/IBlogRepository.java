package com.example.demo.reponsitory;

import com.example.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findByTitleContaining(String name,Pageable page);

//    @Query(value = "select * from Blog ORDER BY category asc;", nativeQuery = true)

    Page<Blog> findAll(Pageable page);

}
