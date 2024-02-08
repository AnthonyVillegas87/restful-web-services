package com.encypher.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "John", LocalDate.now().minusYears(20)));
        users.add(new User(2, "Ray", LocalDate.now().minusYears(10)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(30)));
        users.add(new User(4, "James", LocalDate.now().minusYears(15)));
        users.add(new User(5, "Cristina", LocalDate.now().minusYears(35)));

    }

    public List<User> findAll() {
        return users;
    }



}