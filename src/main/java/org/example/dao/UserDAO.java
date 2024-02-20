package org.example.dao;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> allUsers() {
        return jdbcTemplate.query("SELECT * FROM balance", new UserMapper());
    }

    public User getBalance(Long id) {
        return jdbcTemplate.query("SELECT * FROM balance WHERE user_id=?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
                .stream().findAny().orElse(null);

//          when using your own class UserMapper
//        return jdbcTemplate.query("SELECT * FROM balance WHERE user_id=?", new Object[]{id}, new UserMapper())
//                .stream().findAny().orElse(null);
    }

    public void putMoney(User user,BigDecimal putMoney) {
        jdbcTemplate.update("UPDATE  balance SET current_balance=?  WHERE user_id=?",
                user.getCurrent_balance().add(putMoney), user.getUser_id());
    }

    public void takeMoney(User user, BigDecimal takeMoney) {
        jdbcTemplate.update("UPDATE  balance SET current_balance=?  WHERE user_id=?",
                user.getCurrent_balance().subtract(takeMoney), user.getUser_id());
    }

}
