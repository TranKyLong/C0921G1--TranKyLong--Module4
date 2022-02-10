package casestudy.furama.service.furama_service;

import casestudy.furama.model.AttachService;
import casestudy.furama.model.FuramaService;
import casestudy.furama.model.RentType;
import casestudy.furama.model.ServiceType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFuramaService {

    Page<FuramaService> findAllService(Pageable pageable);

    List<RentType> findAllRentType();
    List<FuramaService> findAll();

    List<AttachService> findAllAttachService();

    Optional<AttachService> findAttachService(Integer id);

    Optional<ServiceType> findServiceType(Integer id);

    Optional<RentType> findRentType(Integer id);

    void saveService(FuramaService furamaService);



}
