package casestudy.furama.model;

import javax.persistence.*;


public class UserRole {
    private Role roleId;
    private User username;

    public UserRole() {
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
