package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class SandwickController {

    @GetMapping(value = "save")
    public String getHome() {
        return "index";
    }

    @PostMapping(value = "save")
    public ModelAndView getSandwick(@RequestParam String[] spice) {
        String totalSpice = Arrays.toString(spice);
        return new ModelAndView("index", "totalSpice", totalSpice);
    }
}
