package casestudy.furama.controller;

import casestudy.furama.model.User;
import casestudy.furama.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {
    @Autowired
    IUserService iUserService;

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping("/login")
    public String getLogin() {
        return "loginpage";
    }
    @GetMapping( {"","/home"})
    public String getHome() {
        return "home";
    }


//    @PostMapping("login")
//    public String saveLogin(@RequestParam String userName, @RequestParam String password) {
//
//        return "redirect:/showuser";
//    }
}
