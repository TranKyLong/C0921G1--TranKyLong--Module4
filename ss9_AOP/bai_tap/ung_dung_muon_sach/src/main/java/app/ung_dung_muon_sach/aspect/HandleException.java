package app.ung_dung_muon_sach.aspect;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class HandleException {

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView showExceptionPage(Exception ex) {
        System.out.println("*************************************************\n");
        ex.getMessage();
        System.out.println("*************************************************\n");
        return new ModelAndView("nullpoiter");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView showIllegalException(Exception ex) {
        System.out.println("*************************************************\n");
        ex.getMessage();
        System.out.println("*************************************************\n");
        return new ModelAndView("illegal");
    }
}
