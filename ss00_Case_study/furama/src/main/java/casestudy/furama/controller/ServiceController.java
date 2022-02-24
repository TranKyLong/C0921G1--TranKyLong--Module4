package casestudy.furama.controller;

import casestudy.furama.dto.CustomerDto;
import casestudy.furama.dto.EmployeeDto;
import casestudy.furama.dto.ServiceDto;
import casestudy.furama.model.*;
import casestudy.furama.service.customer.ICustomerService;
import casestudy.furama.service.furama_service.IFuramaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IFuramaService iFuramaService;

    private boolean isCodeavailable(ServiceDto serviceDto, BindingResult bs) {
        List<FuramaService> serviceList = iFuramaService.findAll();
        for (FuramaService ser : serviceList) {
            if (serviceDto.getServiceCode().equals(ser.getServiceCode())) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("/showservice")
    public ModelAndView showService(@PageableDefault(size = 8) Pageable pageable,
                                    RedirectAttributes ra, Model model) {
        Page<FuramaService> serviceList = iFuramaService.findAllService(pageable);
        ra.addFlashAttribute("msg", "");
        model.addAttribute("deleteFail", "cannot delete the service being rented");
        return new ModelAndView("service/listservice",
                "serviceList", serviceList);
    }

    @GetMapping("/showview/{id}")
    public String viewDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("viewService", iFuramaService.findById(id).get());
        return "/service/viewdetail";
    }

    @GetMapping("/createservice/{id}")
    public String showCreateService(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        System.out.println("da vao create");
        Optional<ServiceType> serviceType = iFuramaService.findServiceType(id);
        System.out.println(serviceType.get().getServiceTypeName() + " -----");
        List<RentType> rentType = iFuramaService.findAllRentType();

        if (serviceType.isPresent()) {

            ServiceDto newService = new ServiceDto();
            newService.setServiceTypeId(serviceType.get());
            model.addAttribute("newService", newService);
            model.addAttribute("rentType", rentType);
        }
        return "service/createservice";

    }

    @PostMapping("saveservice")
    public String saveService(@Validated @ModelAttribute("newService") ServiceDto newService,
                              BindingResult bs,
                              RedirectAttributes ra,
                              Model model) {
        System.out.println("da vao save");
        if (isCodeavailable(newService, bs)) {
            bs.rejectValue("serviceCode", "serviceCode.duplicateCode",
                    "Service Code is available, please enter another code");
        }

        new ServiceDto().validate(newService, bs);
        System.out.println("da tao duoc new service dto");
        if (bs.hasFieldErrors()) {
            model.addAttribute("rentType", iFuramaService.findAllRentType());

            System.out.println("da ve lai create");
            return "service/createservice";
        } else {
            FuramaService furamaService = new FuramaService();
            BeanUtils.copyProperties(newService, furamaService);
            iFuramaService.saveService(furamaService);
            ra.addFlashAttribute("msg", "add new service success");

            System.out.println("return ve showservice");
            return "redirect:/service/showservice";
        }
    }

//    edit

    @GetMapping("editService/{id}")
    public String showEditService(@PathVariable Integer id, Model model, RedirectAttributes ra) {
        Optional<FuramaService> furamaService = iFuramaService.findById(id);

        List<RentType> rentType = iFuramaService.findAllRentType();

        if (furamaService.isPresent()) {

//            ra.addFlashAttribute("Create new service success");
            ServiceDto editService = new ServiceDto();
            BeanUtils.copyProperties(furamaService.get(), editService);
            model.addAttribute("editService", editService);
            model.addAttribute("rentType", rentType);
        }
        return "service/editService";
    }
    //xoa

    @GetMapping("deleteService/{id}")
    public String deleteService(@PathVariable Integer id,
                                RedirectAttributes ra) {

        FuramaService furamaService = iFuramaService.findById(id).get();

        if (id != null) {
            if (!furamaService.isRent()) {
                iFuramaService.deleteById(id);
            }
        } else {
            System.out.println("ko tim thay service");
        }

        return "redirect:/service/showservice";
    }

}
