package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contractId;
    private String startDate;
    private String endDate;
    private Double deposit;
    private Double totalMoney;

    @ManyToOne(targetEntity = Employee.class)
    private Employee employeeId;

    @OneToMany(mappedBy = "contractId")
    private Set<ContractDetail> contractDetailId;

    @ManyToOne(targetEntity = FuramaService.class)
    private FuramaService serviceId;

    @ManyToOne(targetEntity = Customer.class)
    private Customer customerId;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public FuramaService getServiceId() {
        return serviceId;
    }

    public void setServiceId(FuramaService serviceId) {
        this.serviceId = serviceId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public FuramaService getFuramaServiceId() {
        return serviceId;
    }

    public void setFuramaServiceId(FuramaService furamaServiceId) {
        this.serviceId = furamaServiceId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
