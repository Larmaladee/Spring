package com.example.demo1.repos;

import com.example.demo1.Models.Role;
import com.example.demo1.Models.Type;
import org.springframework.data.repository.CrudRepository;

public interface roleRepo extends CrudRepository<Role,Long> {
}
