package app.ung_dung_muon_sach.controller;

import app.ung_dung_muon_sach.model.Book;
import app.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class BookController {

    @Autowired
    IBookService iBookService;

    @GetMapping({"", "book"})
    public ModelAndView showHome(@PageableDefault(size = 8) Pageable pageable,
                                 RedirectAttributes ra) {
        ra.addFlashAttribute("msg", "");

        Page<Book> bookList = iBookService.findAll(pageable);

        return new ModelAndView("home", "bookList", bookList);
    }

    @GetMapping("rentbook/{id}")
    public String showRentPage(@PathVariable Integer id, Model model) {
        Book book =iBookService.findById(id).get();
        if (book.getQuanlity() == 0){
            throw new IllegalArgumentException();
        }
        model.addAttribute("rentedBook", book);
        return "rentbook";
    }

    @GetMapping("/confirmRent/{id}")
    public String confirm(@PathVariable Integer id, RedirectAttributes ra) {
        Book rentedBook = iBookService.findById(id).get();
        int newRentCode = (int) (Math.random() * 99999 + 10000);
        rentedBook.setRentCode(newRentCode);
        System.out.println(newRentCode);
        int newQuanlity = rentedBook.getQuanlity() - 1;
        rentedBook.setQuanlity(newQuanlity);
        iBookService.save(rentedBook);
        ra.addFlashAttribute("msg", "Mượn thành công");
        return "redirect:/book";
    }

    @GetMapping("/bookreturn/{id}")
    public String returnBook(@PathVariable Integer id, Model model) {
        model.addAttribute("bookReturn",iBookService.findById(id).get());
        return "returnbook";
    }

    @PostMapping("bookReturner")
    public String returnBook(@RequestParam Integer id, @RequestParam Integer rentCode,  RedirectAttributes ra){
        Book returnBook = iBookService.findById(id).get();
        int returnCode = returnBook.getRentCode();

        if(rentCode == null ){
            rentCode = -1;
        } else {
            if(!rentCode.equals(returnCode)){
                throw new NullPointerException();
            } else {
                ra.addFlashAttribute("msg","Trả thành công");
                int afterQuanlity = returnBook.getQuanlity()+1;
                returnBook.setQuanlity(afterQuanlity);
                returnBook.setRentCode(null);
                iBookService.save(returnBook);
            }

        }
        return "redirect:/book";
    }

}
