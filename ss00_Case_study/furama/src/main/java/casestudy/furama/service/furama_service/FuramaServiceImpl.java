package casestudy.furama.service.furama_service;

import casestudy.furama.model.AttachService;
import casestudy.furama.model.FuramaService;
import casestudy.furama.model.RentType;
import casestudy.furama.model.ServiceType;
import casestudy.furama.reponsitory.furama_service.IAttachServiceRepository;
import casestudy.furama.reponsitory.furama_service.IFuramaServiceRepository;
import casestudy.furama.reponsitory.furama_service.IRentTypeRepository;
import casestudy.furama.reponsitory.furama_service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuramaServiceImpl implements IFuramaService {
    @Autowired
    IFuramaServiceRepository iFuramaServiceRepository;

    @Autowired
    IServiceTypeRepository iServiceTypeRepository;

    @Autowired
    IRentTypeRepository iRentTypeRepository;

    @Autowired
    IAttachServiceRepository iAttachServiceRepository;

    @Override
    public Page<FuramaService> findAllService(Pageable pageable) {
        return iFuramaServiceRepository.findALlSortByName(pageable);
    }

    @Override
    public List<RentType> findAllRentType() {
        return iRentTypeRepository.findAll();
    }

    @Override
    public List<FuramaService> findAll() {
        return iFuramaServiceRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        iFuramaServiceRepository.deleteById(id);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return iAttachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findAttachService(Integer id) {
        return iAttachServiceRepository.findById(id);
    }

    @Override
    public Optional<ServiceType> findServiceType(Integer id) {
        return iServiceTypeRepository.findById(id);
    }

    @Override
    public Optional<RentType> findRentType(Integer id) {
        return iRentTypeRepository.findById(id);
    }

    @Override
    public void saveService(FuramaService furamaService) {
        iFuramaServiceRepository.save(furamaService);
    }

    @Override
    public Optional<FuramaService> findById(Integer id) {
        return iFuramaServiceRepository.findById(id);
    }

}
