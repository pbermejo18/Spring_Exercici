package com.example.exercici5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(UserResource.USER_RESOURCE)
public class UserResource {
    public static final String USER_RESOURCE = "v0/users";

    UserController userController;
    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    public List<User> users() {
        return userController.getAllUsers();
    }
//save
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userController.getUser(id);
    }

    @GetMapping("{id}/email")
    public Map<String,String> email(@PathVariable("id") String id) {
        return Collections.singletonMap(id, userController.getUser(id).getEmail()); // collections.singletonmap
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        userController.addUser(user);
        return user;
    }

    @DeleteMapping("{id}")
    public void removeUser(@PathVariable("id") String id) {
        userController.removeUser(id);
    }

    @PutMapping("{id}")
    public void editUser(@PathVariable("id") String id, @RequestBody User user) {
        User usernew = userController.getUser(id);
        usernew.setId(user.getId());
        usernew.setFullName(user.getFullName());
        usernew.setEmail(user.getEmail());
        usernew.setPassword(user.getPassword());
        userController.editUser(user);
    }
}