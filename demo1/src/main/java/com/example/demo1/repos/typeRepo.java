package com.example.demo1.repos;

import com.example.demo1.Models.Type;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface typeRepo extends CrudRepository<Type,Long> {


}
