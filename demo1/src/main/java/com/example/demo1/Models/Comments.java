package com.example.demo1.Models;

import org.springframework.lang.NonNull;
import org.springframework.scheduling.config.Task;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS")
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long comment_id;

    @NonNull
    private String comment_text;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Tasks tasks;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Personal personal;

    @NonNull
    public Long getComment_id() {
        return comment_id;
    }

    public void setComment_id(@NonNull Long comment_id) {
        this.comment_id = comment_id;
    }

    @NonNull
    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(@NonNull String comment_text) {
        this.comment_text = comment_text;
    }

    @NonNull
    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(@NonNull Tasks tasks) {
        this.tasks = tasks;
    }

    @NonNull
    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(@NonNull Personal personal) {
        this.personal = personal;
    }
}
