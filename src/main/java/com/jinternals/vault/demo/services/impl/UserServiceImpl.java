package com.jinternals.vault.demo.services.impl;

import com.jinternals.vault.demo.entities.User;
import com.jinternals.vault.demo.repositories.UserRepository;
import com.jinternals.vault.demo.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
