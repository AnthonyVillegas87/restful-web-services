package com.encypher.rest.webservices.restfulwebservices.jpa;

import com.encypher.rest.webservices.restfulwebservices.springDataJpa.UserSpringDataJpaRepository;
import com.encypher.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private UserJdbcRepository repository;

//    @Autowired
//    private UserJpaRepository repository;

    @Autowired
    private UserSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception{
        repository.save(new User(1, "Johnny", LocalDate.now().minusYears(20)));
        repository.save(new User(2, "Mary", LocalDate.now().minusYears(25)));
        
        repository.deleteById(1);

        System.out.println(repository.findById(2));

        System.out.println(repository.findAll());

    }
}
