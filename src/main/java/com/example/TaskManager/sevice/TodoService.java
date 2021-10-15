package com.example.TaskManager.sevice;

import com.example.TaskManager.Entity.TodoEntity;
import com.example.TaskManager.Entity.UserEntity;
import com.example.TaskManager.model.TodoModel;
import com.example.TaskManager.repository.TodoRepo;
import com.example.TaskManager.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final TodoRepo todoRepo;
    private final UserRepo userRepo;

    public TodoService(TodoRepo todoRepo, UserRepo userRepo) {
        this.todoRepo = todoRepo;
        this.userRepo = userRepo;
    }


    public TodoModel createTodo(TodoEntity todo, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        todo.setUser(user);
        return TodoModel.toModel(todoRepo.save(todo));

    }

    public TodoModel completeTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return TodoModel.toModel(todoRepo.save(todo));

    }
}
