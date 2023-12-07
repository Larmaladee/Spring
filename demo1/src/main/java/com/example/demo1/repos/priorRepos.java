package com.example.demo1.repos;

import com.example.demo1.Models.Role;
import com.example.demo1.Models.Task_priorities;
import org.springframework.data.repository.CrudRepository;

public interface priorRepos extends CrudRepository<Task_priorities,Long> {
}