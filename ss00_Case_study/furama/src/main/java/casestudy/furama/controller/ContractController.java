package casestudy.furama.controller;

import casestudy.furama.dto.ContractDto;
import casestudy.furama.dto.CustomerDto;
import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
import casestudy.furama.model.Customer;
import casestudy.furama.reponsitory.furama_service.IServiceTypeRepository;
import casestudy.furama.service.contract.IContractService;
import casestudy.furama.service.customer.ICustomerService;
import casestudy.furama.service.employee.IEmployeeService;
import casestudy.furama.service.furama_service.IFuramaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class ContractController {

    @Autowired
    IContractService iContractService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IFuramaService iFuramaService;

    @GetMapping("showcontract")
    public String showContractList(@PageableDefault(size = 8) Pageable pageable,
                                   Model model,
                                   RedirectAttributes ra,
                                   Optional<String> cusName,
                                   Optional<String> serName) {
        ra.addFlashAttribute("msg", "");
        boolean namePresent = cusName.isPresent();
        boolean servicePresent = serName.isPresent();
        if (namePresent) {
            if (cusName.get().equals("")) {
                namePresent = false;
            }
        }
        if (servicePresent) {
            if (serName.get().equals("")) {
                servicePresent = false;
            }
        }

        if (namePresent) {
            String nameResult = "%" + cusName.get() + "%";
            if (servicePresent) {
                String serviceResult = "%" + serName.get() + "%";
                model.addAttribute("cusName", cusName.get());
                model.addAttribute("serName", serName.get());
                Page<ContractDetail> findByCusNameAndService = iContractService.findByCusNameAndService(nameResult, serviceResult, pageable);
                model.addAttribute("contractDetailList", findByCusNameAndService);
                return "contract/contractlist";
            } else {
                model.addAttribute("cusName", cusName.get());
                Page<ContractDetail> findByCusName = iContractService.findByCusName(nameResult, pageable);
                model.addAttribute("contractDetailList", findByCusName);
                return "contract/contractlist";
            }
        } else {
            if (servicePresent) {
                String serviceResult = "%" + serName.get() + "%";
                model.addAttribute("serName", serName.get());
                Page<ContractDetail> findByService = iContractService.findBySerName(serviceResult, pageable);
                model.addAttribute("contractDetailList", findByService);
                return "contract/contractlist";
            }
        }
        model.addAttribute("contractDetailList", iContractService.findAllContractDetail(pageable));
        return "contract/contractlist";
    }

    static Long getTotalPrice(int deposit, int serviceCost, Long day, int attachPrice, int quantity) {
        return deposit + (serviceCost * day) + (attachPrice * quantity);
    }

    @GetMapping("createcontract/{id}")
    public String createContract(@PathVariable Integer id, Model model) {
        boolean idPresent = iCustomerService.findById(id).isPresent();
        ContractDto contractDto = new ContractDto();
        if (iCustomerService.findById(id).isPresent()) {
            Customer contractCustomer = iCustomerService.findById(id).get();
            contractDto.setCustomerId(contractCustomer);
            model.addAttribute("serviceList", iFuramaService.findAll());
            model.addAttribute("employeeList", iEmployeeService.findAllEmployee());
        } else {
            model.addAttribute("customerList", iCustomerService.findAll());
            model.addAttribute("employeeList", iEmployeeService.findAllEmployee());
            model.addAttribute("serviceList", iFuramaService.findAll());
        }
        model.addAttribute("contractDto", contractDto);
        return "contract/createcontract";

    }


    @PostMapping("savecontract")
    public String saveContract(@Validated @ModelAttribute("contractDto") ContractDto contractDto,
                               BindingResult bs,
                               RedirectAttributes ra,
                               Model model) {
        new ContractDto().validate(contractDto, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("customerList", iCustomerService.findAll());
            model.addAttribute("employeeList", iEmployeeService.findAllEmployee());
            model.addAttribute("serviceList", iFuramaService.findAll());
            return "contract/createcontract";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.saveContract(contract);
            ra.addFlashAttribute("msg", "create new contract success");
            System.out.println("tao thanh cong" + contract.getContractId());
            return "redirect:/showcontract";
        }
    }

}
