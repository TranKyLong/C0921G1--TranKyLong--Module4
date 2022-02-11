package casestudy.furama.service.contract;

import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {

    List<Contract> findAll();

    Page<ContractDetail> findAllContractDetail(Pageable pageable);

    Page<ContractDetail> findByCusName(String name, Pageable pageable);
    Page<ContractDetail> findByCusNameAndService(String name, String serName,Pageable pageable);

    void deleteContract(Integer id);

    void saveContract(Contract contract);
    void saveContractDetail(ContractDetail contractDetail);

    Page<Contract> findContractByCusName(String cusName,Pageable pageable);

    Page<ContractDetail> findBySerName(String serName,Pageable pageable);


}
