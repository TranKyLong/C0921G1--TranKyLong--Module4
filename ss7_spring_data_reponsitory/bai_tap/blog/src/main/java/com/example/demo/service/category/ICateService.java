package com.example.demo.service.category;

import com.example.demo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICateService {

    List<Category> findAll();
}
