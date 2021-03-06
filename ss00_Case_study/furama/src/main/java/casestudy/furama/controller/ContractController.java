package casestudy.furama.controller;

import casestudy.furama.dto.ContractDetailDto;
import casestudy.furama.dto.ContractDto;
import casestudy.furama.model.Contract;
import casestudy.furama.model.ContractDetail;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("contract")
public class ContractController {

    @Autowired
    IContractService iContractService;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    IFuramaService iFuramaService;


    @GetMapping("/show")
    public String showContractDetailList(@PageableDefault(size = 8) Pageable pageable,
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

    @GetMapping("/create")
    public String createContract(Model model) {
        ContractDto contractDto = new ContractDto();
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAllEmployee());
        model.addAttribute("serviceList", iFuramaService.findAll());

        model.addAttribute("contractDto", contractDto);
        return "contract/createcontract";

    }

    @GetMapping("/adddetail/{id}")
    public String addDetail(@PathVariable Integer id, Model model) {

        ContractDetail contractDetail = iContractService.findDetailById(id).get();
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        BeanUtils.copyProperties(contractDetail, contractDetailDto);

        model.addAttribute("attachServiceList", iFuramaService.findAllAttachService());
        model.addAttribute("contractList", iContractService.findAll());

        model.addAttribute("conractDetailDto", contractDetailDto);
        return "contract/createcontractdetailpage";
    }

    @PostMapping("/save")
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
            ContractDetail newContractdetail = new ContractDetail();
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);

            contract.getServiceId().setRent(true);

            iContractService.saveContract(contract);
            newContractdetail.setContractId(contract);
            iContractService.saveContractDetail(newContractdetail);
            ra.addFlashAttribute("msg", "create new contract success");
            System.err.println(contract.getDeposit());
            System.out.println("tao thanh cong" + contract.getContractId());
            return "redirect:/contract/show";
        }
    }

    @GetMapping("contractdetail/create")
    public String createContractDetail(Model model) {
        model.addAttribute("attachServiceList", iFuramaService.findAllAttachService());
        model.addAttribute("contractList", iContractService.findAll());
        model.addAttribute("conractDetailDto", new ContractDetailDto());
        return "contract/createcontractdetailpage";
    }


    @PostMapping("contractdetail/save")
    public String saveContractDetail(@Validated @ModelAttribute("conractDetailDto") ContractDetailDto conractDetailDto,
                                     BindingResult bs,
                                     RedirectAttributes ra,
                                     Model model) {
        new ContractDetailDto().validate(conractDetailDto, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("attachServiceList", iFuramaService.findAllAttachService());
            model.addAttribute("contractList", iContractService.findAll());
            return "contract/createcontractdetailpage";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(conractDetailDto, contractDetail);
            iContractService.saveContractDetail(contractDetail);
            ra.addFlashAttribute("msg", "create new contract detail success");
            System.out.println("tao thanh cong");
            return "redirect:/contract/show";
        }
    }
}
