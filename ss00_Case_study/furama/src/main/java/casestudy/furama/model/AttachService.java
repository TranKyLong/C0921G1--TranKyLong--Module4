package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachId;
    private String attachName;
    private Double attachCost;
    private Integer attachUnit;
    private String attachStatus;

    @OneToMany(mappedBy = "attachServiceId")
    private Set<ContractDetail> contractDetailId;

    public AttachService() {
    }

    public Set<ContractDetail> getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Set<ContractDetail> contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public String getAttachName() {
        return attachName;
    }

    public void setAttachName(String attachName) {
        this.attachName = attachName;
    }

    public Double getAttachCost() {
        return attachCost;
    }

    public void setAttachCost(Double attachCost) {
        this.attachCost = attachCost;
    }

    public Integer getAttachUnit() {
        return attachUnit;
    }

    public void setAttachUnit(Integer attachUnit) {
        this.attachUnit = attachUnit;
    }

    public String getAttachStatus() {
        return attachStatus;
    }

    public void setAttachStatus(String attachStatus) {
        this.attachStatus = attachStatus;
    }
}
