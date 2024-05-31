package com.vitulc.oauthmng.app.entities;

import com.vitulc.oauthmng.app.dtos.UserDto;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    public Users(UserDto userDto, String encryptPassword) {
        this.email = userDto.email();
        this.password = encryptPassword;
        this.username = userDto.username();
    }

    public Users() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
