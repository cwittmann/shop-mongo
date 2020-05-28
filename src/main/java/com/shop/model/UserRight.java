package com.shop.model;

import org.springframework.data.annotation.Id;

public class UserRight {
    @Id
    public String id;
    public String userId;
    public String rightId;

    public UserRight(String id, String userId, String rightId) {
        this.id = id;
        this.userId = userId;
        this.rightId = rightId;
    }
}