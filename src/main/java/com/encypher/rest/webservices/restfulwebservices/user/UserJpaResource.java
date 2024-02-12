package com.encypher.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import com.encypher.rest.webservices.restfulwebservices.jpa.UserRepository;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {


    private UserRepository repository;

    public UserJpaResource(UserRepository repository) {
        this.repository = repository;
    }


    // API to retrieve ALL users {GET}
    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    // API to retrieve A user {GET}{id}
    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> getUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);


        EntityModel<User> entityModel = EntityModel.of(user.get());

        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));


       return entityModel;
    }

    // API to POST a user {POST }
    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
       User savedUser = repository.save(user);


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


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) {
      repository.deleteById(id);

    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getUserPost(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
       return user.get().getPosts();

    }


}
