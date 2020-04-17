package com.labinvent.test.repository.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", unique = true)
    private String password;

    private String roles = "";

    public User setRoles(String roles) {
        this.roles = roles;
        return this;
    }


    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String name) {
        this.email = name;
        return this;
    }

    public String getRole() {
        return roles;
    }

}
