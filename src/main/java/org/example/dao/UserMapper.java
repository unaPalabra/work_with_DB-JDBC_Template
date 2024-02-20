package org.example.dao;

import org.example.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user =new User();

        user.setUser_id(resultSet.getLong("user_id"));
        user.setCurrent_balance(resultSet.getBigDecimal("user_id"));

        return user;
    }
}
