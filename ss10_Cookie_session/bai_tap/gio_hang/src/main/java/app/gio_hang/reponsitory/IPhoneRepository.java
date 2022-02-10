package app.gio_hang.reponsitory;

import app.gio_hang.model.Phone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone,Integer> {

    Page<Phone>findAll(Pageable page);
}
