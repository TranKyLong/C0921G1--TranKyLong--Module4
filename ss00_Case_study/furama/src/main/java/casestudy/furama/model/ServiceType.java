package casestudy.furama.model;

import javax.persistence.*;

import javax.persistence.Entity;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceTypeId")
    private Set<FuramaService> furamaServiceId;

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public Set<FuramaService> getFuramaServiceId() {
        return furamaServiceId;
    }

    public void setFuramaServiceId(Set<FuramaService> furamaServiceId) {
        this.furamaServiceId = furamaServiceId;
    }
}
