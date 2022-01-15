package app.controller;

import app.model.Product;
import app.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller

public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping({"", "home"})
    public String showHomePage(Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("complete", "");
        List<Product> products = iProductService.findAllProduct();
        model.addAttribute("list", products);
        return "homepage";
    }

    @GetMapping("addNew")
    public String showAddingPage(Model model) {
        model.addAttribute("newproduct", new Product());
        return "addnew";
    }

    @PostMapping("save")
    public String saveProduct(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("complete", "ADDED NEW PRODUCTS SUCCESSFUL");
        iProductService.addNew(product);
        return "redirect:/home";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirect) {
        iProductService.deleteProduct(id);
        redirect.addFlashAttribute("complete", "DELETE PRODUCT SUCCESSFUL");
        return "redirect:/home";

    }

    @GetMapping("/{id}/update")
    public String dupdateProduct(@PathVariable int id, Model model) {
        model.addAttribute("updateproduct", iProductService.findById(id));
        return "update";

    }

    @PostMapping("updated")
    public String updatedProduct(Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("complete", "UPDATE PRODUCTS SUCCESSFUL");
        iProductService.editProduct(product);
        return "redirect:/home";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable int id, Model model){
        model.addAttribute("view",iProductService.findById(id));
        return "viewpage";
    }

    @GetMapping("search")
    public String search(@RequestParam String searchname, Model model){
        List<Product> result = iProductService.findByName(searchname);
        model.addAttribute("list", result);
        return "homepage";
    }


}
