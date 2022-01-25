package app.ung_dung_muon_sach.reponsitory;

import app.ung_dung_muon_sach.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
    Page<Book> findAll(Pageable page);


}
