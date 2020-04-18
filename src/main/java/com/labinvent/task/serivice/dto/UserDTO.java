package com.labinvent.task.serivice.dto;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class UserDTO extends EntityDTO {
    @NotEmpty(message = "Please provide a email")
    private String email;

    private String role;

    public String getRole() {
        return role;
    }

    public UserDTO setRole(String role) {
        this.role = role;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(email, userDTO.email) &&
                Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, role);
    }
}
