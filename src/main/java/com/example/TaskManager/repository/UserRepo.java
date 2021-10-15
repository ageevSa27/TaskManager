package com.example.TaskManager.repository;

import com.example.TaskManager.Entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
