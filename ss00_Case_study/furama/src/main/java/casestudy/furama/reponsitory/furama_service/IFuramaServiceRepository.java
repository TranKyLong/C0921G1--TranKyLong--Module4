package casestudy.furama.reponsitory.furama_service;

import casestudy.furama.model.AttachService;
import casestudy.furama.model.FuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IFuramaServiceRepository extends JpaRepository<FuramaService,Integer> {
    @Query(
            value = " SELECT * from furama_service ORDER BY service_type_id_service_type_id  ",
            countQuery = "  select count(*) from furama_service  ",
            nativeQuery = true)
    Page<FuramaService> findALlSortByName(Pageable page);



}
