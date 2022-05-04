package com.example.exercici5;

import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    UserDAO userRepository;
    public UserController(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(String id) {
        Optional<User> user = userRepository.findById(Integer.valueOf(id));
        if (user.isPresent()) return user.get();
        else return null;
    }
    public void addUser(User user) {
        userRepository.save(user);
    }
    public void removeUser(String id) {
        userRepository.deleteById(Integer.valueOf(id));
    }
    public void editUser(User user) {
        userRepository.save(user);
    }
}
