package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eduId;
    private String eduName;

    @OneToMany(mappedBy = "educationDegreeId")
    private Set<Employee> employeeId;

    public EducationDegree() {
    }

    public Integer getEduId() {
        return eduId;
    }

    public void setEduId(Integer eduId) {
        this.eduId = eduId;
    }

    public String getEduName() {
        return eduName;
    }

    public Set<Employee> getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Set<Employee> employeeEdu) {
        this.employeeId = employeeEdu;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }
}
