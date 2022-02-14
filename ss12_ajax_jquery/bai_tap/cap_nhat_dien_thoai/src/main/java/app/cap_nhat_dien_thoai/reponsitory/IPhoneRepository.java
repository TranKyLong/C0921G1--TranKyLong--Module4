package app.cap_nhat_dien_thoai.reponsitory;

import app.cap_nhat_dien_thoai.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPhoneRepository extends JpaRepository<Phone, Integer> {
    Optional<Phone> findById(Integer id);
}
