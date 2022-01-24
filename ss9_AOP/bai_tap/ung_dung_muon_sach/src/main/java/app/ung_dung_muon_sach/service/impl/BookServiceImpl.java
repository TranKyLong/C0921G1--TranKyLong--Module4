package app.ung_dung_muon_sach.service.impl;

import app.ung_dung_muon_sach.model.Book;
import app.ung_dung_muon_sach.reponsitory.IBookRepository;
import app.ung_dung_muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    IBookRepository iBookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return iBookRepository.findAll(pageable);
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return iBookRepository.findById(id);
    }

    @Override
    public void saveBook(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findByRentcode(Integer code) {
        return iBookRepository.findByRentCode(code);
    }
}
