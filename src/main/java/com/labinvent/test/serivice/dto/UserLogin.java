package com.labinvent.test.serivice.dto;

import javax.validation.constraints.NotNull;

public class UserLogin {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public String getEmail() {
        return email;
    }

    public UserLogin setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLogin setPassword(String password) {
        this.password = password;
        return this;
    }
}
