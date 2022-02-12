package app.ung_dung_blog.controller;

import app.ung_dung_blog.model.Blog;
import app.ung_dung_blog.model.Category;
import app.ung_dung_blog.service.blog.IBlogService;
import app.ung_dung_blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("blog/v1")
public class BlogController {

    @Autowired
    ICategoryService iCategoryService;

    @Autowired
    IBlogService iBlogService;


    //xem danh sach category
    @GetMapping("cateList")
    public ResponseEntity<List<String>> getCateList() {  //String để chống lỗi đệ quy mà không cần chỉnh sửa ở Model
        List<Category> categoryList = iCategoryService.findAll();
        List<String> category = new ArrayList<>();
        for (Category c : categoryList) {
            category.add("| ID: " + c.getCateId() + " / " + "Name: " + c.getCateName());
        }
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @GetMapping("blogList")
    public ResponseEntity<List<String>> getBlogList() {
        List<Blog> blogList = iBlogService.getAllBlog();
        List<String> getAllBlog = new ArrayList<>();
        for (Blog c : blogList) {
            getAllBlog.add("ID : " + c.getId());
            getAllBlog.add("Title: " + c.getTitle());
            getAllBlog.add("Author: " + c.getAuthor());
            getAllBlog.add("Price: " + c.getPrice());
            getAllBlog.add("Category: " + c.getCateId().getCateName());
            getAllBlog.add("=========================================" );

        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(getAllBlog, HttpStatus.OK);
    }

    //tim kiem theo category
    @GetMapping("getCategory/{id}")
    public ResponseEntity<List<String>> findAllByCate(@PathVariable int id) {
        List<Blog> blogList = iBlogService.getAllByCategory(id);
        List<String> getAllBlog = new ArrayList<>();
        for (Blog c : blogList) {
            getAllBlog.add("ID : " + c.getId());
            getAllBlog.add("Title: " + c.getTitle());
            getAllBlog.add("Author: " + c.getAuthor());
            getAllBlog.add("Price: " + c.getPrice());
            getAllBlog.add("Category: " + c.getCateId().getCateName());
            getAllBlog.add("=========================================" );

        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllBlog, HttpStatus.OK);
    }

    //xem chi tiet
    @GetMapping("getDetail/{id}")
    public ResponseEntity<List<String>> getDetail(@PathVariable int id) {
        List<Blog> blogList = iBlogService.getDetailById(id);
        List<String> getAllBlog = new ArrayList<>();
        for (Blog c : blogList) {
            getAllBlog.add("<|==================================================|>" );
            getAllBlog.add("   ID : " + c.getId());
            getAllBlog.add("   Title: " + c.getTitle());
            getAllBlog.add("   Author: " + c.getAuthor());
            getAllBlog.add("   Price: " + c.getPrice());
            getAllBlog.add("   Review: " + c.getReview());
            getAllBlog.add("   Category Id: " + c.getCateId().getCateId());
            getAllBlog.add("   Category: " + c.getCateId().getCateName());
            getAllBlog.add("<|==================================================|>" );

        }
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(getAllBlog, HttpStatus.OK);
    }
}
