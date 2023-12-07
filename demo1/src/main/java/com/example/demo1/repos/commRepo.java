package com.example.demo1.repos;

import com.example.demo1.Models.Comments;
import com.example.demo1.Models.Task_priorities;
import org.springframework.data.repository.CrudRepository;

public interface commRepo extends CrudRepository<Comments,Long> {
}
