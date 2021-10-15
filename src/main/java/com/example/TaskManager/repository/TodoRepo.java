package com.example.TaskManager.repository;

import com.example.TaskManager.Entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<TodoEntity, Long> {
}
