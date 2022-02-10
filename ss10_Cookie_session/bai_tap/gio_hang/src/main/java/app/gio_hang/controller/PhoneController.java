package app.gio_hang.controller;

import app.gio_hang.model.Phone;
import app.gio_hang.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Optional;


@Controller
@SessionAttributes("phoneCart")
public class PhoneController {

    @Autowired
    IPhoneService iPhoneService;

    @GetMapping({"", "phone"})
    public ModelAndView showHome(@PageableDefault(size = 8) Pageable pageable,
                                 RedirectAttributes ra) {
        ra.addFlashAttribute("msg", "");
        Page<Phone> phoneList = iPhoneService.findAll(pageable);
        return new ModelAndView("home", "phoneList", phoneList);
    }

    @ModelAttribute("phoneCart")
    public HashMap<Phone, Integer> setSession() {
        System.out.println("tao session");
        return new HashMap<>();
    }

    @GetMapping("addToCart/{id}")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("phoneCart") HashMap<Phone, Integer> hashMap,
                            Model model,
                            RedirectAttributes ra) {
        Phone cartPhone = iPhoneService.findById(id);
        if (cartPhone != null) {
            if (!hashMap.containsKey(cartPhone)) {
                hashMap.put(cartPhone, 1);
            } else {
                hashMap.put(cartPhone, hashMap.get(cartPhone) + 1);
            }
        }
        model.addAttribute("hashMap", hashMap);
        return "cart";
    }

    @GetMapping("changeValue")
    public String changeValue(@RequestParam Integer id,
                              @RequestParam Integer value,
                              @SessionAttribute("phoneCart") HashMap<Phone, Integer> hashMap,
                              RedirectAttributes ra) {
        Phone cartPhone = iPhoneService.findById(id);
        if (value > 0) {
            hashMap.put(cartPhone, value);
        }
        return "cart";
    }

    @GetMapping("seeDetail/{id}")
    public String seeDetail(@PathVariable Integer id, Model model) {
        Phone cartPhone = iPhoneService.findById(id);
        if (cartPhone != null) {
            model.addAttribute("detailPhone", cartPhone);
        }
        return "detail";
    }

    @GetMapping("showCart")
    public String showCart(RedirectAttributes ra){
        ra.addFlashAttribute("msg","");
        return "cart";
    }

    @GetMapping("payment/{id}")
    public String payment(@PathVariable Integer id,
                          RedirectAttributes ra,
                          @SessionAttribute("phoneCart") HashMap<Phone, Integer> hashMap){
        if(id != null){
            Phone paymentPhone = iPhoneService.findById(id);
            hashMap.remove(paymentPhone);
            ra.addFlashAttribute("msg","Thanh toán " + paymentPhone.getName() + " thành công");
            return "redirect:/showCart";
        } else {
            hashMap.clear();
            ra.addFlashAttribute("msg","Thanh toán tất cả thành công");
            return "redirect:/showCart";
        }
    }

}
