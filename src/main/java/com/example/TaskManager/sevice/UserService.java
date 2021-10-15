package com.example.TaskManager.sevice;


import com.example.TaskManager.Entity.UserEntity;
import com.example.TaskManager.exception.UserAlredyExistException;
import com.example.TaskManager.exception.UserNotFoundException;
import com.example.TaskManager.model.UserModel;
import com.example.TaskManager.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserEntity registration(UserEntity user) throws UserAlredyExistException {
        if (userRepo.findByName(user.getName()) != null) {
            throw  new UserAlredyExistException("Пользователь уже существует");
        }
        return userRepo.save(user);
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if( user == null) {
            throw new UserNotFoundException("Пользователь небыл найден");
        }
        return UserModel.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }

}
