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
    public ModelAndView showHome(@PageableDefault(size = 8) @SortDefault(sort = "category") Pageable pageable,
                                 RedirectAttributes ra) {
        ra.addFlashAttribute("msg", "");
        Page<Book> bookList = iBookService.findAll(pageable);
        for (Book b : iBookService.findAll(pageable)
        ) {
            if (b.getRentCode() == null) {
                b.setRented(false);
            }
        }

        return new ModelAndView("homepage", "bookList", bookList);
    }

    @GetMapping("rentConfirm")
    public String confirmedRent(@RequestParam Optional<Integer> enterRentCode, RedirectAttributes ra) {
        if (enterRentCode.isPresent()) {
            Book backBook = iBookService.findByRentcode(enterRentCode.get());
            if (backBook == null) {
                ra.addFlashAttribute("msg", "Mã thuê sai, mời nhập lại");
            } else {
                int afterBookBack = backBook.getQuantily() + 1;
                backBook.setQuantily(afterBookBack);
                backBook.setRentCode(null);
                iBookService.saveBook(backBook);
                ra.addFlashAttribute("msg", "Trả thành công");
            }
        }
        return "redirect:/book";
    }

    @GetMapping("rentbook/{id}")
    public String rentAction(@PathVariable Integer id, Model model, RedirectAttributes ra) {

        Book rentedBook = iBookService.findById(id).get();
        if (rentedBook.getQuantily() == 0) {
            throw new IllegalArgumentException();
        }
        /** sau khi mượn thì set lại số lượng sách -1*/
        int quantilyAfter = rentedBook.getQuantily() - 1;
        rentedBook.setQuantily(quantilyAfter);

        /** cung cấp mã mượn sách */
        rentedBook.setRentCode((int) (Math.random() * 99999 + 10000));
        iBookService.saveBook(rentedBook);

        ra.addFlashAttribute("msg", "Mượn thành công");
        return "redirect:/book";
    }


}
