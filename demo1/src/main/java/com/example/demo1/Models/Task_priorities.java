package com.example.demo1.Models;

import org.springframework.lang.NonNull;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "task_priorities")
public class Task_priorities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long priority_id;

    @NonNull
    private String priority_name;

    @OneToMany(mappedBy = "task_priorities")
    private List<Tasks> tasks;

    @NonNull
    public Long getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(@NonNull Long priority_id) {
        this.priority_id = priority_id;
    }

    @NonNull
    public String getPriority_name() {
        return priority_name;
    }

    public void setPriority_name(@NonNull String priority_name) {
        this.priority_name = priority_name;
    }

    public List<Tasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<Tasks> tasks) {
        this.tasks = tasks;
    }
}
