package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        if (user != null) {
            userRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
        if(id!=null) {
            return userRepository.findById(id);
        }
        return Optional.empty();
    }
}
