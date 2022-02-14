package app.quan_ly_dien_thoai.reponsitory;

import app.quan_ly_dien_thoai.model.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhonesRepository extends JpaRepository<Phones,Integer> {
}
