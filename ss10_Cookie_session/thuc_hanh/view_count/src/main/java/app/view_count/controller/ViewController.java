package app.view_count.controller;

import app.view_count.model.ViewCouter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("viewCounter" )
public class ViewController {

    @ModelAttribute("viewCounter")
    public ViewCouter setUpCounter() {
        return new ViewCouter();
    }

    @GetMapping({"", "view"})
    public String showHome(@ModelAttribute("viewCounter") ViewCouter viewCouter) {
        viewCouter.viewIncrease();
        return "home";
    }
}
