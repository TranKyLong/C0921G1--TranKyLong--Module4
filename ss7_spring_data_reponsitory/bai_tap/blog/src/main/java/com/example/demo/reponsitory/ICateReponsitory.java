package com.example.demo.reponsitory;

import com.example.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICateReponsitory extends JpaRepository<Category,Integer> {
}
