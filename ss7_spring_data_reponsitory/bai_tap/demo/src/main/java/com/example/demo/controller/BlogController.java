package com.example.demo.controller;


import com.example.demo.model.Blog;
import com.example.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    static List<String> categoryList;

    static {
        categoryList = new ArrayList<>();
        categoryList.add("Fashion Blogs");
        categoryList.add("Food Blogs");
        categoryList.add("Sports Blogs");
        categoryList.add("Travel Blogs");
        categoryList.add("Music Blogs");
        categoryList.add("Lifestyle Blogs");
        categoryList.add("Fitness Blogs");
        categoryList.add("Political Blogs");
    }


    @Autowired
    IBlogService iBlogService;

    @GetMapping({"", "blog"})
    public String showHomePage(Model model, RedirectAttributes ra) {
        model.addAttribute("list", iBlogService.showALL());
        ra.addFlashAttribute("messenger", "");
        return "home";
    }

    @GetMapping("delete/{id}")
    public String showEdit(@PathVariable Integer id, RedirectAttributes ra) {
        iBlogService.delete(id);
        ra.addFlashAttribute("messenger", "Delete success");
        return "redirect:/blog";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        Blog newBlog = new Blog();
        model.addAttribute("myblog", newBlog);
        model.addAttribute("categoryList", categoryList);
        return "/createform";
    }

    @PostMapping("save")
    public String save(Blog myBlog, RedirectAttributes ra) {
        iBlogService.save(myBlog);
        ra.addFlashAttribute("messenger", "Add new blog successfuly");
        return "redirect:/blog";
    }

    @GetMapping("update/{id}")
    public ModelAndView showUpdateForm(@PathVariable Integer id,Model model) {
        model.addAttribute("categoryList", categoryList);
        Optional<Blog> updateBlog =  iBlogService.findById(id);
        if (updateBlog.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("update");
            modelAndView.addObject("updateBlog", updateBlog.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error404");
            return modelAndView;
        }
    }

    @PostMapping("/saveupdate")
    public String saveUpdate(Blog myBlog, RedirectAttributes ra) {
        iBlogService.save(myBlog);
        ra.addFlashAttribute("messenger", "Update blog successfuly");
        return "redirect:/blog";
    }

    @GetMapping("reading/{id}")
    public ModelAndView showReadPage(@PathVariable Integer id) {
        Optional<Blog> readBlog =  iBlogService.findById(id);
        return new ModelAndView("showcontent", "readBlog", readBlog);

    }
}