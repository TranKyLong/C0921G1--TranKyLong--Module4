package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postd;
    private String posName;

    @OneToMany(mappedBy = "posId")
    private Set<Employee> employeeId;

    public Position() {
    }

    public Set<Employee> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Set<Employee> employees) {
        this.employeeId = employees;
    }

    public Integer getPostd() {
        return postd;
    }

    public void setPostd(Integer postd) {
        this.postd = postd;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
