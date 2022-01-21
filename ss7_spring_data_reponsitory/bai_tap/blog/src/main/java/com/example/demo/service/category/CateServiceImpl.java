package com.example.demo.service.category;

import com.example.demo.model.Category;
import com.example.demo.reponsitory.ICateReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateServiceImpl implements ICateService {

    @Autowired
    ICateReponsitory iCateReponsitory;

    @Override
    public List<Category> findAll() {
        return iCateReponsitory.findAll();
    }
}
