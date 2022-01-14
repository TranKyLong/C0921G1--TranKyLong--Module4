package app.controller;

import app.model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmailController {
    @GetMapping({"", "email"})
    public String showHomePage(Model model) {
        List<String> langList = new ArrayList<>();
        langList.add("English");
        langList.add("Vietnamese");
        langList.add("Japanese");
        langList.add("Chinese");

        model.addAttribute("langList",langList);

        List<Integer> pageList = new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(20);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        model.addAttribute("pageList",pageList);

        EmailConfig emailConfig = new EmailConfig();
        model.addAttribute("email", emailConfig);
        return "/index";
    }

    @PostMapping("email")
    public ModelAndView getConfig(@ModelAttribute EmailConfig emailConfig){
        List<EmailConfig>configList = new ArrayList<>();
        configList.add(emailConfig);
        return new ModelAndView("index","config",configList);

    }
}
