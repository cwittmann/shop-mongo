package com.shop.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    public String id;
    public String firstName;
    public String lastName;
    public String city;

    public User(String id, String firstName, String lastName, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }
}