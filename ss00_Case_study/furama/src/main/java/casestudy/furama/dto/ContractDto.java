package casestudy.furama.dto;

import casestudy.furama.model.ContractDetail;
import casestudy.furama.model.Customer;
import casestudy.furama.model.Employee;
import casestudy.furama.model.FuramaService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ContractDto implements Validator {
    private Integer contractId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private Double deposit;
    private Double totalMoney;
    private Employee employeeId;
    private Set<ContractDetail> contractDetailId;
    private FuramaService serviceId;
    private Customer customerId;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Set<ContractDetail> getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Set<ContractDetail> contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public FuramaService getServiceId() {
        return serviceId;
    }

    public void setServiceId(FuramaService serviceId) {
        this.serviceId = serviceId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    static long distanceDay(String starDate, String endDate) throws IllegalArgumentException, ParseException {
        DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        Date date1 = null;
        Date date2 = null;

        date1 = simpleDateFormat.parse(starDate);
        date2 = simpleDateFormat.parse(endDate);

        long getDiff = date2.getTime() - date1.getTime();
        long dateIff;
        dateIff = getDiff / (24 * 60 * 60 * 1000);
        if (!(dateIff > 0)) {
            throw new IllegalArgumentException();
        } else {
            return dateIff;
        }
    }

    @Override
    public void validate(Object target, Errors errors) {
        String dateValidation = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

        ContractDto contractDto = (ContractDto) target;
//        if (!contractDto.startDate.matches(dateValidation)) {
//            errors.rejectValue("startDate", "startDate.wrongStarDate", "format must be dd/mm/yyyy");
//        }
//        if (!contractDto.endDate.matches(dateValidation)) {
//            errors.rejectValue("endDate", "endDate.wrongEndDate", "format must be dd/mm/yyyy");
//        }

        if (contractDto.deposit == null) {
            errors.rejectValue("deposit", "deposit.nullDeposit", "deposit must not be blank");
        } else if (!(contractDto.deposit > 0)) {
            errors.rejectValue("deposit", "deposit.wrongDeposit", "deposit must be greater than 0");
        }

        if (contractDto.deposit > contractDto.serviceId.getServiceCost()) {
            errors.rejectValue("deposit", "deposit.notSuitableDeposit", "deposit must not greater than service cost");
        }

        try {
            long getDiff = contractDto.endDate.getTime() - contractDto.startDate.getTime();

            long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
            if (!((getDaysDiff) > 0)) {
                errors.rejectValue("endDate", "endDate.wrongBookDate", "Please select a valid date");
                errors.rejectValue("startDate", "startDate.wrongBookDate", "Please select a valid date");
            }
        } catch (Exception e) {
            errors.rejectValue("endDate", "endDate.wrongParse", "Please select a valid date");
        }

    }
}
