package com.spring.security.dao.user.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.spring.security.dao.user.role.model.UserRole;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Kizurashi on 2/12/2018.
 */
@Entity( name = "User" )
@Transactional
@Table( name = "user" )
public class User implements Serializable {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private Integer id;

    @Column( name = "username", unique = true, nullable = false, length = 60 )
    private String username;

    @Column( name = "password", nullable = false, length = 260 )
    private String password;

    @Column( name = "firstName",  nullable = false, length = 260 )
    private String firstname;

    @Column( name = "lastName",  nullable = false, length = 260 )
    private String lastname;

    @Column( name = "emailAdd", unique = true, nullable = false, length = 100 )
    private String emailAdd;

    @Enumerated(EnumType.STRING)
    @NotEmpty
    @ManyToMany( fetch = FetchType.EAGER )
    @JoinTable(name = "user_privilegde",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<UserRole> userProfiles = new HashSet<UserRole>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public Set<UserRole> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(Set<UserRole> userProfiles) {
        this.userProfiles = userProfiles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getFirstname() != null ? !getFirstname().equals(user.getFirstname()) : user.getFirstname() != null)
            return false;
        if (getLastname() != null ? !getLastname().equals(user.getLastname()) : user.getLastname() != null)
            return false;
        return getEmailAdd() != null ? getEmailAdd().equals(user.getEmailAdd()) : user.getEmailAdd() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
        result = 31 * result + (getLastname() != null ? getLastname().hashCode() : 0);
        result = 31 * result + (getEmailAdd() != null ? getEmailAdd().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", emailAdd='" + emailAdd + '\'' +
                '}';
    }
}
