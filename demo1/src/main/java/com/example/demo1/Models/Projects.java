package com.example.demo1.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "PROJECTS")
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long project_id;

    @NonNull
    private String project_name;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Personal personal;

    @NonNull
    public Long getProject_id() {
        return project_id;
    }

    public void setProject_id(@NonNull Long project_id) {
        this.project_id = project_id;
    }

    @NonNull
    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(@NonNull String project_name) {
        this.project_name = project_name;
    }

    @NonNull
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(@NonNull Personal personal) {
        this.personal = personal;
    }
}
