package com.example.bai_tap_ung_dung_blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {


    @Autowired
    IBlogService iBlogService;

    @GetMapping({"", "blog"})
    public String showHomePage(Model model, RedirectAttributes ra) {
        model.addAttribute("list", iBlogService.showALL());
        ra.addFlashAttribute("messenger", "");
        return "home";
    }

    @GetMapping("delete/{id}")
    public String showEdit(@PathVariable Long id, RedirectAttributes ra) {
        iBlogService.delete(id);
        ra.addFlashAttribute("messenger", "Delete success");
        return "redirect:/blog";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        Blog newBlog = new Blog();
        model.addAttribute("myblog", newBlog);
        return "/createform";
    }

    @PostMapping("save")
    public String save(Blog myBlog, RedirectAttributes ra) {
        iBlogService.save(myBlog);
        ra.addFlashAttribute("messenger", "Add new blog successfuly");
        return "redirect:/blog";
    }

    @GetMapping("update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("updateBlog", iBlogService.findById(id));
        return "update";
    }

    @PostMapping("/saveupdate")
    public String saveUpdate (Blog myBlog, RedirectAttributes ra){
        iBlogService.save(myBlog);
        ra.addFlashAttribute("messenger", "Update blog successfuly");
        return "redirect:/blog";
    }

    @GetMapping("read/{id}")
    public String showReadPage(@PathVariable Long id, Model model) {
        model.addAttribute("readBlog", iBlogService.findById(id));
        return "showcontent";
    }
}
