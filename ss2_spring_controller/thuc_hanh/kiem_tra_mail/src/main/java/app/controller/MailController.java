package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class MailController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern = Pattern.compile(EMAIL_REGEX);
    private Matcher matcher;

    @GetMapping(value = "mail")
    public String getHome() {
        return "index";
    }


    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    @PostMapping("mail")
    public ModelAndView validateEmail(String inputMail) {
        boolean isValid = this.validate(inputMail);
        String ok = "Email is OK";
        if (!isValid) {
            ok = "Email is invalid";
        }
        return new ModelAndView("index", "message", ok);
    }
}
