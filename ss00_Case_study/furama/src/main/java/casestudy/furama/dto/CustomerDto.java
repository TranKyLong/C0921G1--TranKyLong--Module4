package casestudy.furama.dto;

import casestudy.furama.model.Contract;
import casestudy.furama.model.CustomerType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Set;

public class CustomerDto implements Validator {
    private Integer customerId;

    private CustomerType customerType;

    private String customerCode;

    private String customerName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date customerBirthday;
    private Integer customerGender;

    private String customerIdCard;
    private String customerPhone;

    private String customerEmail;

    private String customerAdress;

    private Set<Contract> contractId;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Integer getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Integer customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAdress() {
        return customerAdress;
    }

    public void setCustomerAdress(String customerAdress) {
        this.customerAdress = customerAdress;
    }

    public Set<Contract> getContractId() {
        return contractId;
    }

    public void setContractId(Set<Contract> contractId) {
        this.contractId = contractId;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String dateValidation = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        CustomerDto cusDto = (CustomerDto) target;
//        if (!cusDto.customerBirthday.matches(dateValidation)) {
//            errors.rejectValue("customerBirthday", "customerBirthday.wrongCusDate", "format must be dd/mm/yyyy");
//        }
        if (!cusDto.customerIdCard.matches("^\\d{9,10}$")) {
            errors.rejectValue("customerIdCard", "customerIdCard.wrongCusIdCard", "The id card must be between 9 and 10 digits long");
        }
        if (!cusDto.customerCode.matches("^(KH-)[0-9]{4}$")) {
            errors.rejectValue("customerCode", "customerCode.wrongCusCode",
                    "must be in the format KH-XXXX (X is the number 0-9)");
        }

        if (!cusDto.customerName.matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("customerName", "customerName.wrongCusName", "Can not contain special characters");
        }
        if (!(cusDto.customerPhone.matches("^(84+|0)(90|91)[0-9]{7}$"))) {
            errors.rejectValue("customerPhone", "customerPhone.wrongCusPhone",
                    "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx");
        }
        if (!cusDto.customerEmail.matches("^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")) {
            errors.rejectValue("customerEmail", "customerEmail.wrongCusMail", "Wrong format Email");
        }
    }
}
