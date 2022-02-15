package app.bo_sung_i18n.controller;

import app.bo_sung_i18n.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    private static List<Customer> customerList;

    static {
        customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Ninh", 20));
        customerList.add(new Customer(2, "Dương", 21));
        customerList.add(new Customer(3, "Lan", 22));
        customerList.add(new Customer(4, "Ngọc", 23));
    }

    @GetMapping({"", "/home"})
    public ModelAndView getHome() {
        return new ModelAndView("home", "customerList", customerList);
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id) {
        for (Customer cus : customerList) {
            if (cus.getId() == id) {
                customerList.remove(cus);
                return "redirect:/home";
            }

        } return "home";
    }
}
