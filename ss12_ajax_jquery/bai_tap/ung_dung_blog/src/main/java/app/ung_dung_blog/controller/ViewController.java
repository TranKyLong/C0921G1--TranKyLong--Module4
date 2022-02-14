package app.ung_dung_blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping({"","/blogHome"})
    public String showHomePage(){
        return "/HomePage";
    }
}
