package com.example.demo1.Models;

import org.springframework.lang.NonNull;

import javax.annotation.Priority;
import javax.persistence.*;

@Entity
@Table(name = "TASKS")
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long task_id;

    @NonNull
    private String title;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "priority_id")
    private Task_priorities task_priorities;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Task_statuses task_statuses;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects projects;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "assigned_to")
    private Personal personal;

    @NonNull
    public Long getTask_id() {
        return task_id;
    }

    public void setTask_id(@NonNull Long task_id) {
        this.task_id = task_id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }
    @NonNull
    public Task_priorities getTask_priorities() {
        return task_priorities;
    }

    public void setTask_priorities(Task_priorities task_priorities) {
        this.task_priorities = task_priorities;
    }

    @NonNull
    public Task_statuses getTask_statuses() {
        return task_statuses;
    }

    public void setTask_statuses(@NonNull Task_statuses task_statuses) {
        this.task_statuses = task_statuses;
    }

    @NonNull
    public Projects getProjects() {
        return projects;
    }

    public void setProjects(@NonNull Projects projects) {
        this.projects = projects;
    }

    @NonNull
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(@NonNull Personal personal) {
        this.personal = personal;
    }
}
