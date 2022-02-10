package casestudy.furama.controller;

import casestudy.furama.dto.EmployeeDto;
import casestudy.furama.dto.ServiceDto;
import casestudy.furama.model.*;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class ServiceController {
    @Autowired
    IFuramaService iFuramaService;

    @GetMapping("showservice")
    public ModelAndView showService(@PageableDefault(size = 8) Pageable pageable,
                                    RedirectAttributes ra) {
        Page<FuramaService> serviceList = iFuramaService.findAllService(pageable);
        ra.addFlashAttribute("msg","");
        return new ModelAndView("service/listservice",
                "serviceList", serviceList);
    }

    @GetMapping("createservice/{id}")
    public String showCreateService(@PathVariable Integer id, Model model) {
        Optional<ServiceType> serviceType = iFuramaService.findServiceType(id);
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
                              Model model){
        new ServiceDto().validate(newService, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("rentType", iFuramaService.findAllRentType());

            return "service/createservice";
        } else {
            FuramaService furamaService = new FuramaService();
            BeanUtils.copyProperties(newService, furamaService);
            iFuramaService.saveService(furamaService);
            ra.addFlashAttribute("msg", "add new service success");
            return "redirect:/showservice";
        }
    }
}
