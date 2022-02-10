package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "divisionId")
    private Set<Employee> employeeId;

    public Set<Employee> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Set<Employee> employeeDivision) {
        this.employeeId = employeeDivision;
    }

    public Division() {
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
}
