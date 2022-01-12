package app.controller;

import app.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DictionaryController {

    @Autowired
    IDictionaryService iDictionaryService;
//    IDictionaryService iDictionaryService = new DictionaryServiceImpl();
    @GetMapping(value = "dictionary")
    public String getHompage() {
        return "index";
    }

    @PostMapping(value = "dictionary")
    public ModelAndView getWord(@RequestParam String word) {
        String result = iDictionaryService.findByWord(word);
        return new ModelAndView("index", "result", result);
    }
}

