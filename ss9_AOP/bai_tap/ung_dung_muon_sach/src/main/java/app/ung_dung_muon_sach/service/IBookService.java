package app.ung_dung_muon_sach.service;

import app.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBookService  {
    Page<Book>findAll(Pageable pageable);

    Optional<Book> findById(Integer id);

    void saveBook(Book book);

    Book findByRentcode(Integer code);
}
