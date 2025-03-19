package com.exam.exam.Model;

import jakarta.persistence.*;

@Entity
@Table(name="userRole_Details")
public class userRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userRoleId;

    private String roleName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public userRole(Role role, User user, String roleName, long userRoleId) {
        this.role = role;
        this.user = user;
        this.roleName = roleName;
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        return "userRole{" +
                "userRoleId=" + userRoleId +
                ", roleName='" + roleName + '\'' +
                ", user=" + user +
                ", role=" + role +
                '}';
    }

    public userRole() {
    }
}
