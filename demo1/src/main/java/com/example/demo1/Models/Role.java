package com.example.demo1.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long role_id;

    @NonNull
    private String role_name;

    @NonNull
    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(@NonNull Long role_id) {
        this.role_id = role_id;
    }

    @NonNull
    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(@NonNull String role_name) {
        this.role_name = role_name;
    }
}
