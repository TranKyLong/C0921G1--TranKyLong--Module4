package app.controller;

import app.model.Employee;
import app.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping({"", "employee"})
public class EmployeController {

    @Autowired
    IEmployeeService iEmployeeService;

    @GetMapping({"", "employee"})
    public String showHomePage(Model model) {
        List<Employee> showEmployee = iEmployeeService.findAll();
        model.addAttribute("empoyeeList", showEmployee);
        return "index";
    }

    @GetMapping(value = "create")
    public String showCreateForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute(employee);
        return "showform";
    }

    @PostMapping(value = "create")
    public String createNewEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {

        iEmployeeService.getNewEmployee(employee);
        redirectAttributes.addFlashAttribute("success",
                " successfully added new employee with name " + employee.getName());
        return "redirect:/employee";
    }
}


