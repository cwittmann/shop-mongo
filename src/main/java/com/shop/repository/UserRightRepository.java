package com.shop.repository;

import com.shop.model.UserRight;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRightRepository extends MongoRepository<UserRight, String> {

}