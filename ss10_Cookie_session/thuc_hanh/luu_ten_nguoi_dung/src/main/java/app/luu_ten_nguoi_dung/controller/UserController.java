package app.luu_ten_nguoi_dung.controller;

import app.luu_ten_nguoi_dung.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class UserController {

    @ModelAttribute("user")
    public User getUser() {
        return new User();
    }

    @GetMapping({"", "showuser"})
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "loginpage";
    }

    @PostMapping("login")
    public String saveLogin(@ModelAttribute("user") User user,
                            Model model,
                            @CookieValue(value = "setUser", defaultValue = "") String setUser,
                            HttpServletResponse response,
                            HttpServletRequest request) {

        return "redirect:/showuser";
    }
}
