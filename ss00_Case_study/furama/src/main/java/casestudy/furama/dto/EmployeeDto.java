package casestudy.furama.dto;

import casestudy.furama.model.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Integer employeeId;

    @NotBlank(message = "Name must not be blank")
    private String employeeName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;


    private String employeeIdCard;

    private Double employeeSalary;


    private String employeePhone;
    private String employeeMail;
    private String employeeAdress;
    private Position posId;

    private EducationDegree educationDegreeId;

    private Division divisionId;

    private User username;

    private Set<Contract> contractSet;

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeMail() {
        return employeeMail;
    }

    public void setEmployeeMail(String employeeMail) {
        this.employeeMail = employeeMail;
    }

    public String getEmployeeAdress() {
        return employeeAdress;
    }

    public void setEmployeeAdress(String employeeAdress) {
        this.employeeAdress = employeeAdress;
    }

    public Position getPosId() {
        return posId;
    }

    public void setPosId(Position posId) {
        this.posId = posId;
    }

    public EducationDegree getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(EducationDegree educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public Division getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Division divisionId) {
        this.divisionId = divisionId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Set<Contract> getContractSet() {
        return contractSet;
    }

    public void setContractSet(Set<Contract> contractSet) {
        this.contractSet = contractSet;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        String dateValidation = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
        EmployeeDto employeeDto = (EmployeeDto) target;
//        String birthday = String.valueOf(employeeDto.employeeBirthday);
//        System.out.println();
//        if (!birthday.matches(dateValidation)) {
//            errors.rejectValue("employeeBirthday", "employeeBirthday.wrongDate", "format must be dd/mm/yyyy");
//        }

        if (!employeeDto.employeeName.matches("^[\\p{Lu}\\p{Ll}\\s0-9]*$")) {
            errors.rejectValue("employeeName", "employeeName.wrongChar", "Can not contain special characters");
        }
        if (!employeeDto.employeeIdCard.matches("^\\d{9,10}$")) {
            errors.rejectValue("employeeIdCard", "employeeIdCard.wrongIdCard", "The id card must be between 9 and 10 digits long");
        }

        if (employeeDto.employeeSalary == null) {
//
//            employeeDto.setEmployeeSalary(0.0);
            errors.rejectValue("employeeSalary", "employeeSalary.nullSalary", "salary must not be blank");
        } else if (employeeDto.employeeSalary < 0) {
            errors.rejectValue("employeeSalary", "employeeSalary.wrongSalary", "salary must be positive");
        }
        if (employeeDto.employeePhone == null) {
            employeeDto.setEmployeePhone("0");
            errors.rejectValue("employeePhone", "employeePhone.nullPhone", "phone number must not be blank");
        }

        if (!(employeeDto.employeePhone.matches("^(84+|0)(90|91)[0-9]{7}$"))) {
            errors.rejectValue("employeePhone", "employeePhone.wrongPhone",
                    "Phone number must be in the correct format 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx");
        }
        if (!employeeDto.employeeMail.matches("^[A-Za-z0-9._]+[@][A-Za-z0-9._]+[.][A-Za-z0-9._]+$")) {
            errors.rejectValue("employeeMail", "employeeMail.wrongMail", "Wrong format Email");
        }

        // validate inputs ...
        if(employeeDto.employeeBirthday == null){
            errors.rejectValue("employeeBirthday", "employeeBirthday.wrongBirth", "Birthday must no be blank");
        } else {
            DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            long millis=System.currentTimeMillis();
            Date curDate = new java.sql.Date(millis);
            int empBirth = Integer.parseInt(formatter.format(employeeDto.employeeBirthday));
            int curentDate = Integer.parseInt(formatter.format(curDate));

            int age = (curentDate - empBirth) / 10000;
            if(age < 18){
                errors.rejectValue("employeeBirthday", "employeeBirthday.wrongAge", "Employee age must not smaller than 18");
            }
        }


    }
}
