package casestudy.furama.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    private boolean isDisable;

    @ManyToMany(mappedBy = "users")
    private Set<Role> employeeUser;


    public User() {
    }

    public boolean isDisable() {
        return isDisable;
    }

    public void setDisable(boolean disable) {
        this.isDisable = disable;
    }

    public Set<Role> getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(Set<Role> employeeUser) {
        this.employeeUser = employeeUser;
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
