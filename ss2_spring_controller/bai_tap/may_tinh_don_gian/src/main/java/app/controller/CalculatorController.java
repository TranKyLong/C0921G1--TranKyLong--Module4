package app.controller;

import app.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping(value = "calculator")
    public String getCalculator() {
        return "index";
    }

    @PostMapping(value = "calculator")
    public ModelAndView getResult(@RequestParam String number1, @RequestParam String number2, @RequestParam String operator) {
        String rs = iCalculatorService.calculate(number1, number2, operator);
        return new ModelAndView("index", "rs", rs);
    }
}
