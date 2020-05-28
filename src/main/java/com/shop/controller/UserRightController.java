package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.UserRight;
import com.shop.repository.UserRightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserRightController {

    @Autowired
    private UserRightRepository userRightRepository;

    @GetMapping("/userRights")
    public List<UserRight> getUserRights() {
        return userRightRepository.findAll();
    }

    @GetMapping("/userRights/{id}")
    public UserRight getUserRight(@PathVariable String id) {
        return userRightRepository.findById(id).orElseThrow(() -> new NotFoundException("UserRight not found: " + id));
    }

    @PostMapping("/userRights")
    public UserRight postUserRight(@RequestBody UserRight userRight) {
        return userRightRepository.save(userRight);
    }

    @PutMapping("/userRights/{id}")
    public UserRight putUserRight(@RequestBody UserRight newUserRight, @PathVariable String id) {
        return userRightRepository.findById(id).map(userRight -> {
            return userRightRepository.save(newUserRight);
        }).orElseThrow(() -> new NotFoundException("UserRight not found: " + id));
    }

    @DeleteMapping("/userRights/{id}")
    public void deleteUserRight(@PathVariable String id) {
        userRightRepository.deleteById(id);
    }
}