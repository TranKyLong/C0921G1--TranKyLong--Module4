package controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping(value = "hello")
    public ModelAndView getHello() {
        return new ModelAndView("hello", "sayhello", "HELLO ALL");
    }
}
