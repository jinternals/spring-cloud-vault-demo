package com.jinternals.vault.demo.controllers;

import com.jinternals.vault.demo.configuration.SomeProperties;
import com.jinternals.vault.demo.entities.User;
import com.jinternals.vault.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    private SomeProperties someProperties;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users")
    public List<User> getTestConfig() {
        System.out.println("Level 0 : " + someProperties);

        return userService.getAllUsers();
    }

}
