package com.example.exercici5;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    List<User> llistaUsers = new ArrayList<>();

    public UserRepository() {
        llistaUsers.add(new User(1,"pol@gmail.com","1234","Pol"));
        llistaUsers.add(new User(2,"u2@gmail.com","123456","Usuari 2"));
    }

    public List<User> findAll() {
        return llistaUsers;
    }

    public void addUser(User user) {
        llistaUsers.add(user);
    }

    public User findById(Integer id) {
        Optional<User> user = llistaUsers.stream().filter(u -> u.getId() == id).findAny();
        if (user.isPresent()) return user.get();
        else return null;
    }

    public User findByName(String fullname) {
        Optional<User> user = llistaUsers.stream().filter(u -> u.getFullName().equals(fullname)).findAny();
        if (user.isPresent()) return user.get();
        else return null;
    }

    public void removeUserById(Integer id) {
        llistaUsers.removeIf(user -> user.getId() == id);
    }
}
