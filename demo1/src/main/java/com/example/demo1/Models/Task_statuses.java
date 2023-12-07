package com.example.demo1.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "task_statuses")
public class Task_statuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long status_id;

    @NonNull
    private String status_name;

    @OneToMany(mappedBy = "task_statuses")
    private List<Tasks> tasks;

    @NonNull
    public Long getStatus_id() {
        return status_id;
    }

    public void setStatus_id(@NonNull Long status_id) {
        this.status_id = status_id;
    }

    @NonNull
    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(@NonNull String status_name) {
        this.status_name = status_name;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}
