package com.encypher.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {


    // UserDao -> Static List
    // for testing purpose, the UserDao will retrieve data from a static list of users
    // I will make use of JPA/Hibernate -> Database

    private static int usersCount = 0;
   private static List<User> users = new ArrayList<>();

//    static {
//        users.add(new User(++usersCount, "John", LocalDate.now().minusYears(20)));
//        users.add(new User(++usersCount, "Ray", LocalDate.now().minusYears(10)));
//        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(30)));
//        users.add(new User(++usersCount, "James", LocalDate.now().minusYears(15)));
//        users.add(new User(++usersCount, "Cristina", LocalDate.now().minusYears(35)));
//
//    }

    public List<User> findAll() {
        return users;
    }

    public User findUser(int id) {
        for(User user : users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;


        // TO-DO ---->  Refactor to use functional programming later
    }

    public User saveUser(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        List<User> userList = users;
        for(int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            if(user.getId() == id) {
                userList.remove(i);
                break;
            }
        }

        // TODO --> ANOTHER TASK FOR FUNCTIONAL PROGRAMMING
    }



}
