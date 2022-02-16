package app.spring_security_blog.controller;

import app.spring_security_blog.model.Blog;
import app.spring_security_blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"", "home"})
    public ModelAndView showHome() {
        return new ModelAndView("bloghome", "blogList", iBlogService.findAll());
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable int id) {
        iBlogService.delete(id);
        return "redirect:/home";
    }

    @GetMapping("writenew")
    public String writeNewBlog(Model model) {
        model.addAttribute("newBlog", new Blog());
        return "writeblog";
    }

    @PostMapping("savenewblog")
    public String saveNewBlog(@ModelAttribute("newBlog") Blog newBlog) {
        iBlogService.save(newBlog);
        return "redirect:/home";

    }
}
