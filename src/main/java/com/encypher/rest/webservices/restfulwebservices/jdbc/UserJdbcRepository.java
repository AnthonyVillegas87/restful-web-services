package com.encypher.rest.webservices.restfulwebservices.jdbc;

import com.encypher.rest.webservices.restfulwebservices.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY = """
            
            INSERT INTO "user" (id, name, birth_date)
            VALUES(?, ?, ?);
       
            
            """;

    private static String DELETE_QUERY = """
            
            DELETE FROM "user" WHERE id = ?
            
            """;


    private static String SELECT_QUERY = """
            
            SELECT * FROM "user" WHERE id = ?
            
            """;

    public void insert(User user) {
        springJdbcTemplate.update(INSERT_QUERY, user.getId(), user.getName(), user.getBirthDate());
    }

    public void deleteById(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public User findById(int id) {
      return  springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(User.class), id);
    }

}
