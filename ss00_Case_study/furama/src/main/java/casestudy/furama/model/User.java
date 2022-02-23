package casestudy.furama.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    private boolean isDisable;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    private Set<Role> role;

    @OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
    private Employee employeeId;

    public User() {
    }

    public Set<Role> getRole() {
        return role;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        this.isDisable = disable;
    }

    public Set<Role> getRoles() {
        return role;
    }

    public void setRole(Set<Role> employeeUser) {
        this.role = employeeUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
