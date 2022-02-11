package casestudy.furama.dto;

import casestudy.furama.model.AttachService;
import casestudy.furama.model.Contract;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;

public class ContractDetailDto implements Validator {
    private Integer detailId;
    private Contract contractId;

    private AttachService attachServiceId;
    private int quantity;

    public ContractDetailDto() {
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Contract getContractId() {
        return contractId;
    }

    public void setContractId(Contract contractId) {
        this.contractId = contractId;
    }

    public AttachService getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(AttachService attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
        if (!(contractDetailDto.quantity > 0)) {
            errors.rejectValue("quantity", "quantity.wrongQuantity", "quantity must be greater than 0");
        }
    }
}
