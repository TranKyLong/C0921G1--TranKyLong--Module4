package casestudy.furama.controller;

import casestudy.furama.dto.CustomerDto;
import casestudy.furama.model.Customer;
import casestudy.furama.model.CustomerType;
import casestudy.furama.service.customer.ICustomerService;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    @GetMapping({"showcustomerlist"})
    public String getAllCustomer(Model model,
                                 RedirectAttributes ra,
                                 @PageableDefault(value = 8) Pageable pageable,
                                 @RequestParam(defaultValue = "") String findName,
                                 @RequestParam(defaultValue = "") String findcode,
                                 @RequestParam(defaultValue = "") String findtype) {

        model.addAttribute("customerList", iCustomerService.searchCustomer(findName, findcode, findtype, pageable));
        model.addAttribute("typeList", iCustomerService.getAllCustomerType());
        ra.addFlashAttribute("msg", "");
        return "customer/customerlist";
    }

    @GetMapping("addcustomer")
    public ModelAndView addCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/addcustomer");
        CustomerDto customerDto = new CustomerDto();
        modelAndView.addObject("customerDto", customerDto);
        modelAndView.addObject("customerTypeList", iCustomerService.getAllCustomerType());
        for (CustomerType type : iCustomerService.getAllCustomerType()) {
            System.out.println(type.getTypeName());
        }
        return modelAndView;
    }

    @PostMapping("savecustomer")
    public String saveCustomer(@Validated @ModelAttribute("customerDto") CustomerDto customerDto,
                               BindingResult bs,
                               RedirectAttributes ra,
                               Model model) {
        new CustomerDto().validate(customerDto, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("customerTypeList", iCustomerService.getAllCustomerType());
            return "customer/addcustomer";
        } else {
            Customer saveCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, saveCustomer);
            iCustomerService.saveCustomer(saveCustomer);
            ra.addFlashAttribute("msg", "add new customer success");
            System.out.println("tao thanh cong" + saveCustomer.getCustomerName());
            return "redirect:/showcustomerlist";
        }
    }

    @GetMapping("editcustomer/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {

        if (iCustomerService.findById(id).isPresent()) {
            Customer customer = iCustomerService.findById(id).get();

            CustomerDto customerDto = new CustomerDto();
            BeanUtils.copyProperties(customer, customerDto);
            model.addAttribute("editCustomer", customerDto);
            model.addAttribute("customerTypeList", iCustomerService.getAllCustomerType());
            return "customer/editcustomer";
        }
        return "customer/customerlist";
    }

    @PostMapping("saveeditcustomer")
    public String saveEdit(@Validated @ModelAttribute("editCustomer") CustomerDto editCustomer,
                           BindingResult bs,
                           RedirectAttributes ra,
                           Model model) {

        new CustomerDto().validate(editCustomer, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("customerTypeList", iCustomerService.getAllCustomerType());
            return "customer/editcustomer";
        } else {
            Customer saveCustomer = new Customer();
            BeanUtils.copyProperties(editCustomer, saveCustomer);
            iCustomerService.saveCustomer(saveCustomer);
            ra.addFlashAttribute("msg", "Edit customer success");
            System.out.println("edit thanh cong" + saveCustomer.getCustomerName());
            return "redirect:/showcustomerlist";
        }

    }

    @GetMapping("deletecustomer/{id}")
    public String deleteCustomer(@PathVariable Integer id,
                                 RedirectAttributes ra) {
        if (id != null) {
            System.out.println("lay duoc id la ::: " + id);
            iCustomerService.deleteCustomerById(id);
            System.out.println("xoa thanh cong ::: " + id);
            ra.addFlashAttribute("msg", "delete customer success");
            return "redirect:/showcustomerlist";
        } else {
            ra.addFlashAttribute("msg", "fail to delete customer");
            System.out.println("ko tim thay customer");
            return "redirect:/showcustomerlist";
        }
    }
}
