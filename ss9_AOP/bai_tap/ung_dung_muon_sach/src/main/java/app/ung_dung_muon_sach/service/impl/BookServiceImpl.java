//package app.ung_dung_muon_sach.service.impl;
//
//import app.ung_dung_muon_sach.model.Book;
//import app.ung_dung_muon_sach.reponsitory.IBookRepository;
//import app.ung_dung_muon_sach.service.IBookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//
//@Service
//public class BookServiceImpl  {
//
//    @Autowired
//    IBookRepository iBookRepository;
//
//    @Override
//    public Page<Book> findAll(Pageable pageable) {
//        Page<Book> bookList = iBookRepository.findAll(pageable);
//        for (Book b : bookList) {
//            if (b.getRentCode() == null) {
//                b.setRented(false);
//            }
//        }
//        return bookList;
//    }
//
//    @Override
//    public Optional<Book> findById(Integer id) {
//        return iBookRepository.findById(id);
//    }
//
//    @Override
//    public void saveBook(Book book) {
//        iBookRepository.save(book);
//    }
//
//    @Override
//    public Book findByRentcode(Integer code) {
//        return iBookRepository.findByRentCode(code);
//    }
//
//    @Override
//    public String returnBook(Integer rentCode, Integer id) {
//        Book bookReturn = this.findById(id).get();
//        if (rentCode == null) {
//            rentCode = -1;
//        }
//        if (rentCode == -1) {
//            return "vui lòng nhập mã";
//        } else {
//            if (bookReturn.getRentCode()!= null && !bookReturn.getRentCode().equals(rentCode)) {
//                return "mã sai, vui lòng nhập lại";
//            }
//            if (bookReturn.getRentCode()!= null && bookReturn.getRentCode().equals(rentCode)) {
//                return "ok";
//            }
//        }
//        return "error";
//    }
//
//    @Override
//    public void rentBook(Integer id) {
//        Book rentedBook = this.findById(id).get();
//        if (rentedBook.getQuantily() == 0) {
//            throw new IllegalArgumentException();
//        }
//        /** sau khi mượn thì set lại số lượng sách -1*/
//        int quantilyAfter = rentedBook.getQuantily() - 1;
//        rentedBook.setQuantily(quantilyAfter);
//
//        /** cung cấp mã mượn sách */
//        int newRentCode = (int) (Math.random() * 99999 + 10000);
//        rentedBook.setRentCode(newRentCode);
//        this.saveBook(rentedBook);
//    }
//}
