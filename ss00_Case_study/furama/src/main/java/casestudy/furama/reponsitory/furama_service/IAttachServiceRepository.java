package casestudy.furama.reponsitory.furama_service;

import casestudy.furama.model.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAttachServiceRepository extends JpaRepository<AttachService,Integer> {

}
