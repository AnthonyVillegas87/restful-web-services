package com.encypher.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDaoService.findUser(id);

        if(user == null) {
            throw new UserNotFoundException("id: " + id);
        }
       return user;
    }

    // API to POST a user {POST }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
       User savedUser = userDaoService.saveUser(user);


       // 1. To the URI of the current request, I added a path "/{id}"
         // 2. Replace the variable {id} with the ID of the created USER.
            // 3. Convert it to the URI & return it back.
              // 4. The method returns the User with the correct HTTP status code 201 --> created a new resource on the server.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return  ResponseEntity.created(location).build();
    }





}
