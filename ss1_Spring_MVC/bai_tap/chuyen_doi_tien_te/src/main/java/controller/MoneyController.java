package controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoneyController {
    @GetMapping(value = "convert")
    public String convert(){
        return "index";
    }

    @PostMapping(value = "convert")
    public ModelAndView result(@RequestParam int rate, @RequestParam int usd){
        int result = usd * rate;
        if (result <= 0) {
                return new ModelAndView("index","resultfail","RATE OR USD NUMBER MUST BE OVER 0");
        }
        return new ModelAndView("index","result", result);
    }
}
