package app.quan_ly_dien_thoai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/")
    public String showIndex() {
        return "/phonelist";
    }

}
