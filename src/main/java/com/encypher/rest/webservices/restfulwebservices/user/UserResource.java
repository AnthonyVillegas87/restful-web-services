package com.encypher.rest.webservices.restfulwebservices.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {

    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }


    // API to retrieve ALL users {GET}
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDaoService.findAll();
    }

    // API to retrieve A user {GET}{id}
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
       return userDaoService.findUser(id);

    }

}