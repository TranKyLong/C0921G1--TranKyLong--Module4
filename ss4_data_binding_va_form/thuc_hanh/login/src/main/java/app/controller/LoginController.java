package app.controller;

import app.model.LoginAccount;
import app.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    IAccountService iAccountService;

    @GetMapping({"", "login"})
    public String showLogin(Model model) {
        LoginAccount account = new LoginAccount();
        model.addAttribute("loginAccount", account);
        return "index";
    }

    @PostMapping("login")
    public String accountDetailt(@ModelAttribute LoginAccount account, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
        LoginAccount acc = iAccountService.validateAccount(account);
        if (acc == null) {
            redirectAttributes.addFlashAttribute("msg", "Login Faild, Wrong password or ID!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Welcome " + acc.getFullName());
            redirectAttributes.addFlashAttribute("detail","ACCOUNT DETAIL");
            redirectAttributes.addFlashAttribute("acc",acc);
        }
        return "redirect:login";
    }
}
