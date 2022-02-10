package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentId;
    private String rentName;
    private Double rentCost;

    @OneToMany(mappedBy = "rentTypeId")
    private Set<FuramaService> furamaServiceId;


    public RentType() {
    }

    public Set<FuramaService> getFuramaServiceId() {
        return furamaServiceId;
    }

    public void setFuramaServiceId(Set<FuramaService> furamaServiceSet) {
        this.furamaServiceId = furamaServiceSet;
    }

    public Integer getRentId() {
        return rentId;
    }

    public void setRentId(Integer rentId) {
        this.rentId = rentId;
    }

    public String getRentName() {
        return rentName;
    }

    public void setRentName(String rentName) {
        this.rentName = rentName;
    }

    public Double getRentCost() {
        return rentCost;
    }

    public void setRentCost(Double rentCost) {
        this.rentCost = rentCost;
    }
}
