package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customerId;

    public CustomerType() {
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Set<Customer> customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(Integer customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getTypeName() {
        return customerTypeName;
    }

    public void setTypeName(String typeName) {
        this.customerTypeName = typeName;
    }
}
