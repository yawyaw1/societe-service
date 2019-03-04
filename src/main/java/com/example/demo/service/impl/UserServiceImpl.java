package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Adservio on 07/12/2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean create(User user) {
        if (user != null) {
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(User user) {
        if (user != null) {
            userRepository.saveAndFlush(user);
            return true;
        }
        return false;
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }
}
