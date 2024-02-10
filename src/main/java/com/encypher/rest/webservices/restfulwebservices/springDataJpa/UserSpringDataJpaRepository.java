package com.encypher.rest.webservices.restfulwebservices.springDataJpa;

import com.encypher.rest.webservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringDataJpaRepository extends JpaRepository<User, Integer> {



}
