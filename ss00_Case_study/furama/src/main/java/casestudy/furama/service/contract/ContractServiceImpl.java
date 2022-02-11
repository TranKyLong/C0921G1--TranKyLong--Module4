package casestudy.furama.service.contract;

import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
import casestudy.furama.reponsitory.contract.IContractDetail;
import casestudy.furama.reponsitory.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    IContractRepository iContractRepository;

    @Autowired
    IContractDetail iContractDetail;

    @Override
    public List<Contract> findAll() {
        return iContractRepository.findAll();
    }

    @Override
    public Page<ContractDetail> findAllContractDetail(Pageable pageable) {
        return iContractDetail.findAll(pageable);
    }

    @Override
    public Page<ContractDetail> findByCusName(String name, Pageable pageable) {
        return iContractDetail.findByCustomerName(name,pageable);
    }

    @Override
    public Page<ContractDetail> findByCusNameAndService(String name, String serName, Pageable pageable) {
        return iContractDetail.findByCustomerNameAndService(name,serName,pageable);
    }

    @Override
    public void deleteContract(Integer id) {
        iContractRepository.deleteById(id);
    }

    @Override
    public void saveContract(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public void saveContractDetail(ContractDetail contractDetail) {
        iContractDetail.save(contractDetail);
    }

    @Override
    public Page<Contract> findContractByCusName(String cusName, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ContractDetail> findBySerName(String serName, Pageable pageable) {
        return iContractDetail.findByServiceName(serName,pageable);
    }

}
