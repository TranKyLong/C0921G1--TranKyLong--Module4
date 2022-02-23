package casestudy.furama.controller;

import casestudy.furama.dto.CustomerDto;
import casestudy.furama.dto.EmployeeDto;
import casestudy.furama.model.Customer;
import casestudy.furama.model.CustomerType;
import casestudy.furama.model.Employee;
import casestudy.furama.service.customer.ICustomerService;
import casestudy.furama.service.employee.IEmployeeService;
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
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping("showemployee")
    public ModelAndView showEmployee(@PageableDefault(size = 8) Pageable pageable,
                                     RedirectAttributes ra,
                                     Model model,
                                     @RequestParam(defaultValue = "") String findName,
                                     @RequestParam(defaultValue = "") String divisionId,
                                     @RequestParam(defaultValue = "") String education,
                                     @RequestParam(defaultValue = "") String position) {
        ra.addFlashAttribute("msg", "");
        model.addAttribute("findName",findName);
        model.addAttribute("divisionId",divisionId);
        model.addAttribute("education",education);
        model.addAttribute("position",position);

        model.addAttribute("divisionList", iEmployeeService.findAllDivision());
        model.addAttribute("educationList", iEmployeeService.findAllEdu());
        model.addAttribute("positionList", iEmployeeService.findAllPos());
        Page<Employee> employeeList = iEmployeeService.searchEmployee(findName, divisionId, education, position,pageable);

        return new ModelAndView("employee/employeelist", "employeeList", employeeList);
    }

    @GetMapping("addnewemployee")
    public String addCustomer(Model model) {
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto", employeeDto);
        model.addAttribute("eduList", iEmployeeService.findAllEdu());
        model.addAttribute("posList", iEmployeeService.findAllPos());
        model.addAttribute("divisionList", iEmployeeService.findAllDivision());

        return "employee/addemployee";

    }

    @PostMapping("saveemployee")
    public String saveCustomer(@Validated @ModelAttribute("employeeDto") EmployeeDto employeeDto,
                               BindingResult bs,
                               RedirectAttributes ra,
                               Model model) {
        new EmployeeDto().validate(employeeDto, bs);
        if (bs.hasFieldErrors()) {
//            model.addAttribute("employeeDto", employeeDto);
            model.addAttribute("eduList", iEmployeeService.findAllEdu());
            model.addAttribute("posList", iEmployeeService.findAllPos());
            model.addAttribute("divisionList", iEmployeeService.findAllDivision());
            return "employee/addemployee";
        } else {
            Employee saveThisEmployee = new Employee();
            BeanUtils.copyProperties(employeeDto, saveThisEmployee);
            iEmployeeService.saveEmployee(saveThisEmployee);
            ra.addFlashAttribute("msg", "add new employee success");
            System.out.println("tao thanh cong" + saveThisEmployee.getEmployeeName());
            return "redirect:/employee/showemployee";
        }
    }

    @GetMapping("editemployee/{id}")
    public String editCustomer(@PathVariable Integer id, Model model) {

        if (iEmployeeService.findById(id).isPresent()) {
            Employee employee = iEmployeeService.findById(id).get();

            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            model.addAttribute("editEmployee", employeeDto);
            model.addAttribute("eduList", iEmployeeService.findAllEdu());
            model.addAttribute("posList", iEmployeeService.findAllPos());
            model.addAttribute("divisionList", iEmployeeService.findAllDivision());
            return "employee/editemployee";
        }
        return "employee/employeelist";
    }

    @PostMapping("saveeditemployee")
    public String saveEdit(@Validated @ModelAttribute("editEmployee") EmployeeDto editEmployee,
                           BindingResult bs,
                           RedirectAttributes ra,
                           Model model) {
        new EmployeeDto().validate(editEmployee, bs);
        if (bs.hasFieldErrors()) {
            model.addAttribute("employeeDto", editEmployee);
            model.addAttribute("eduList", iEmployeeService.findAllEdu());
            model.addAttribute("posList", iEmployeeService.findAllPos());
            model.addAttribute("divisionList", iEmployeeService.findAllDivision());
            return "employee/editemployee";
        } else {
            Employee saveThisEmployee = new Employee();
            BeanUtils.copyProperties(editEmployee, saveThisEmployee);
            iEmployeeService.saveEmployee(saveThisEmployee);
            ra.addFlashAttribute("msg", "edit employee success");
            System.out.println("edit thanh cong" + saveThisEmployee.getEmployeeName());
            return "redirect:/employee/showemployee";
        }
    }

    //
    @GetMapping("deleteemployee/{id}")
    public String deleteCustomer(@PathVariable Integer id,
                                 RedirectAttributes ra) {
        if (id != null) {
            System.out.println("lay duoc employee id la ::: " + id);

            iEmployeeService.deleteEmployeeById(id);
            System.out.println("xoa thanh cong employee ::: " + id);
            ra.addFlashAttribute("msg", "delete employee success");
            return "redirect:/employee/showemployee";
        } else {
            ra.addFlashAttribute("msg", "fail to delete employee");
            System.out.println("ko tim thay empployee");
            return "redirect:/employee/showemployee";
        }
    }

}
