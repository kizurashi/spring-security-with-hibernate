package com.spring.security.dao.user.role.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kizurashi on 2/12/2018.
 */
@Entity( name = "UserRole" )
@Table( name = "USER_PROFILE" )
@JsonRootName(value = "USER_PROFILE")
public class UserRole implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "role", nullable = false )
    private String role = UserRoleType.USER.toString();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (getId() != null ? !getId().equals(userRole.getId()) : userRole.getId() != null) return false;
        return getRole() != null ? getRole().equals(userRole.getRole()) : userRole.getRole() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getRole() != null ? getRole().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
