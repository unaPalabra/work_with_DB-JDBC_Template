package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class User {
    @JsonProperty("user_id")
    private Long user_id;
    @JsonProperty("current_balance")
    private BigDecimal current_balance;

    public User() {
    }

    public User(Long user_id, BigDecimal current_balance) {
        this.user_id = user_id;
        this.current_balance = current_balance;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getCurrent_balance() {
        return current_balance;
    }

    public void setCurrent_balance(BigDecimal current_balance) {
        this.current_balance = current_balance;
    }
}
