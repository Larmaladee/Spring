package com.example.demo1.repos;

import com.example.demo1.Models.Personal;
import org.springframework.data.repository.CrudRepository;

public interface userRepo extends CrudRepository<Personal,Long> {

    Personal findByUsername(String username);
}
