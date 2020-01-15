package com.gi.userManagemnentApp.repository;

import com.gi.userManagemnentApp.dto.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    List<User> userList =new ArrayList<>();


    public List<User> getAllUsers() {
        return userList;
    }

    public User getUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if(first.isPresent()){
            return first.get();
        }else{
           return new User();
        }
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public User updateUser(User user) {
        for(User u1: userList){
            if(u1.getId().equals(user.getId()))
            {
                u1.setName(user.getName());
                u1.setAddress(user.getAddress());
                return u1;
            }
        }
        return new User();
    }

    public User deleteUser(String id) {
        Optional<User> first = userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if(first.isPresent()){
            User user = first.get();
            return user;
        }else{
            return new User();
        }

    }
}
