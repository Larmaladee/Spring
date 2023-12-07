package com.example.demo1.Models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "TYPE")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long category_id;

    @NonNull
    private String category_name;

    @NonNull
    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(@NonNull Long category_id) {
        this.category_id = category_id;
    }

    @NonNull
    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(@NonNull String category_name) {
        this.category_name = category_name;
    }
}
