package app.validate_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountDto implements Validator {

    private Integer id;

    @NotBlank(message = "This field can not be blank")
    private String firstName;

    @NotBlank(message = "This field can not be blank")
    private String lastName;

    @NotBlank(message = "This field can not be blank")
    private String phoneNumber;

    @NotNull
    private Integer age;

    @NotBlank(message = "This field can not be blank")
    private String mail;

    public AccountDto() {
    }

    public AccountDto(Integer id, @NotBlank(message = "This field can not be blank") String firstName, @NotBlank(message = "This field can not be blank") String lastName, @NotBlank(message = "This field can not be blank") String phoneNumber, @NotBlank(message = "This field can not be blank") Integer age, @NotBlank(message = "This field can not be blank") String mail) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        if (!accountDto.getFirstName().matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("firstName", "firstName.wrongChar", "Can not contain special characters");
        }
        if (accountDto.getFirstName().length() < 5 || accountDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "firstName.wrongLength", "minimum 5 characters and maximum 45 characters");
        }
        if (!accountDto.getLastName().matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("lastName", "lastName.wrongChar", "Can not contain special characters");
        }
        if (accountDto.getLastName().length() < 5 || accountDto.getLastName().length() > 45) {
            errors.rejectValue("lastName", "lastName.wrongLength", "minimum 5 characters and maximum 45 characters");
        }
        if (accountDto.getAge() == null) {
            errors.rejectValue("age", "age.null", "This field can not be blank");
        } else {
            if (accountDto.getAge() < 18) {
                errors.rejectValue("age", "age.wrongAge", "at least 18 years old");
            }
        }


        if (!accountDto.getPhoneNumber().matches("^(0|84)[0-9]{8,9}$")) {
            errors.rejectValue("phoneNumber", "phoneNumber.wrongLength", "minimum 9 number and maximum 10 number");
        }
    }
}
