package app.controller;

import app.model.ToKhaiYTe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YTeController {

    @GetMapping({"", "tokhaiyte"})
    public String showForm(Model model) {

        ToKhaiYTe toKhaiYTe = new ToKhaiYTe();
        model.addAttribute("toKhai", toKhaiYTe);

        return "index";
    }

    @PostMapping("dakhaibao")
    public String showCompleteForm(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model) {
        model.addAttribute("tokhaicomplete", toKhaiYTe);
        return "dakhaibao";
    }

    @PostMapping("khaibaolai")
    public String showKhaiBaoLai(@ModelAttribute ToKhaiYTe toKhaiYTe, Model model) {
        model.addAttribute("tokhaibaolai", toKhaiYTe);
        return "khaibaolai";
    }
}
