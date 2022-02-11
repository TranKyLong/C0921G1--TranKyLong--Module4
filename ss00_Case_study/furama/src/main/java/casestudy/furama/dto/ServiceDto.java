package casestudy.furama.dto;

import casestudy.furama.model.Contract;
import casestudy.furama.model.RentType;
import casestudy.furama.model.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ServiceDto implements Validator {
    private Integer serviceId;


    private String serviceCode;

    private String serviceName;
    private String freeService;

    private Integer serviceArea;

    private Double serviceCost;

    private Integer maxPeople;
    private RentType rentTypeId;
    private ServiceType serviceTypeId;
    private Set<Contract> contractId;
    private String standarRoom;

    private String description;

    private Double poolArea;
    private int floorsNumber;


    public ServiceDto() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(Integer serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(RentType rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public ServiceType getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(ServiceType serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public Set<Contract> getContractId() {
        return contractId;
    }

    public void setContractId(Set<Contract> contractId) {
        this.contractId = contractId;
    }

    public String getStandarRoom() {
        return standarRoom;
    }

    public void setStandarRoom(String standarRoom) {
        this.standarRoom = standarRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        ServiceDto serviceDto = (ServiceDto) target;
        if (!serviceDto.serviceCode.matches("^(DV-)[0-9]{4}$")) {
            errors.rejectValue("serviceCode", "serviceCode.wrongSerCode", "Service Code format is DV-XXXX (X is number 0-9)");
        }
        if (!(serviceDto.floorsNumber>0)) {
            errors.rejectValue("floorsNumber", "floorsNumber.wrongFloor",
                    "number of floors must be greater than 0");
        }
        if (!(serviceDto.serviceCost>0)) {
            errors.rejectValue("serviceCost", "serviceCost.wrongCost",
                    "Service Cost must be greater than 0");
        }
    }
}
