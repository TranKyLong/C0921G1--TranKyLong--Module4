package casestudy.furama.service.contract;

import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable);

    Page<ContractDetail> findAllContractDetail(Pageable pageable);

    Page<ContractDetail> findByCusName(String name, Pageable pageable);
    Page<ContractDetail> findByCusNameAndService(String name, String serName,Pageable pageable);

    void deleteContract(Integer id);

    void saveContract(Contract contract);

    Page<Contract> findContractByCusName(String cusName,Pageable pageable);

    Page<ContractDetail> findBySerName(String serName,Pageable pageable);


}
