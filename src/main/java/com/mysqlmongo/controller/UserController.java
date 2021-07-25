package com.mysqlmongo.controller;

import com.mysqlmongo.entity.User;
import com.mysqlmongo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/*
 * @author Jeff
 * @date 7/25/21 12:19 AM
 */
@RestController
public class UserController {
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserMapper userRepository) {
        this.userMapper = userRepository;
    }
//
//    @PostMapping("/user")
//    public User createUser(@RequestBody User user) {
//        user.setId(UUID.randomUUID().toString());
//        userRepository.save(user);
//        return user;
//    }
//
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }
}
