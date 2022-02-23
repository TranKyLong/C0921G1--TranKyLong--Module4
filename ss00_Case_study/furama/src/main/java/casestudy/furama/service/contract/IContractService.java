package casestudy.furama.service.contract;

import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IContractService {

    List<Contract> findAll();

    Page<Contract>searchContract(String customerName,
                                 String empId,
                                 String serId,
                                 Pageable pagle);


    Page<ContractDetail> findAllContractDetail(Pageable pageable);

    Page<ContractDetail> findByCusName(String name, Pageable pageable);
    Page<ContractDetail> findByCusNameAndService(String name, String serName,Pageable pageable);

    void deleteContract(Integer id);

    Optional<ContractDetail>findDetailById(Integer id);
    void saveContract(Contract contract);
    void saveContractDetail(ContractDetail contractDetail);

    Page<Contract> findContractByCusName(String cusName,Pageable pageable);

    Page<ContractDetail> findBySerName(String serName,Pageable pageable);


}
