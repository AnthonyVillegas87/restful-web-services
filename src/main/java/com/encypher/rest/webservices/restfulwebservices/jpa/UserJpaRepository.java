package com.encypher.rest.webservices.restfulwebservices.jpa;

import com.encypher.rest.webservices.restfulwebservices.user.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserJpaRepository {
 @PersistenceContext
  private  EntityManager entityManager;

  public void insert(User user) {
    entityManager.merge(user);
  }

  public User findById(int id) {
    return entityManager.find(User.class, id);
  }

  public void deleteById(int id) {
    User user = entityManager.find(User.class, id);
    entityManager.remove(user);
  }
}
