package app.ung_dung_muon_sach.service;

import app.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);

    Optional<Book> findById(Integer id);

    void save(Book book);
}
