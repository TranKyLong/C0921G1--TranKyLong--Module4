package app.validate_form.controller;

import app.validate_form.dto.AccountDto;
import app.validate_form.model.ValidateAccount;
import app.validate_form.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AccountController {

    @Autowired
    IAccountService iAccountService;

    @GetMapping({"", "register"})
    public String showForm(Model model, RedirectAttributes ra) {
        model.addAttribute("newAccount", new AccountDto());
        ra.addFlashAttribute("mess", "");
        return "register";
    }

    @PostMapping("saveAcc")
    public String registerValidate(@Validated @ModelAttribute("newAccount") AccountDto newAccount,
                                   BindingResult bs,
                                   RedirectAttributes ra) {
        new AccountDto().validate(newAccount, bs);
        if (bs.hasFieldErrors()) {
            return "register";
        } else {
            ValidateAccount validateAccount = new ValidateAccount();
            BeanUtils.copyProperties(newAccount, validateAccount);
            iAccountService.save(validateAccount);
            ra.addFlashAttribute("mess", "Sign Up Success");
            return "redirect:/register";

        }

    }
}
