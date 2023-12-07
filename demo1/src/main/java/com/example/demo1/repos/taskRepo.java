package com.example.demo1.repos;

import com.example.demo1.Models.Task_statuses;
import com.example.demo1.Models.Tasks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.config.Task;

public interface taskRepo extends CrudRepository<Tasks,Long> {
}
