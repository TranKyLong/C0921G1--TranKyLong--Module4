package dictionary_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import services.DictionaryServiceImpl;
import services.IDictionaryService;


@Controller
public class DicontionaryController {

   private IDictionaryService dictionaryService = new DictionaryServiceImpl() ;
    @GetMapping("dictionary")
    public String getDictionary() {
        return "index";
    }

    @PostMapping("dictionary")
    public ModelAndView getWord(@RequestParam String word){
       String result = dictionaryService.getWord(word);
       return new ModelAndView("index", "result",result);
    }
}
