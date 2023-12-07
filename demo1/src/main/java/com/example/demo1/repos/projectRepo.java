package com.example.demo1.repos;

import com.example.demo1.Models.Projects;
import com.example.demo1.Models.Task_priorities;
import org.springframework.data.repository.CrudRepository;

public interface projectRepo extends CrudRepository<Projects,Long> {
}
