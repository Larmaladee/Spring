package com.example.demo1.repos;

import com.example.demo1.Models.Role;
import com.example.demo1.Models.Task_statuses;
import org.springframework.data.repository.CrudRepository;

public interface statRepo extends CrudRepository<Task_statuses,Long> {
}
