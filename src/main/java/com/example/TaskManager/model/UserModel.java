package com.example.TaskManager.model;

import com.example.TaskManager.Entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {
    private Long id;
    private String name;
    private List<TodoModel> todoModels;


    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setTodoModels(entity.getTodos().stream().map(TodoModel::toModel).collect(Collectors.toList()));
        return model;
    }

    public UserModel() {
    }

    public List<TodoModel> getTodoModels() {
        return todoModels;
    }

    public void setTodoModels(List<TodoModel> todoModels) {
        this.todoModels = todoModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
