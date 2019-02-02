package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

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
            Supplier<Boolean> supplier = () -> {
                userRepository.saveAndFlush(user);
                return true;
            };
            return supplier.get();
        }
        return false;
    }

    @Override
    public Optional<Boolean> update(User user) {
        Function<User, Optional<Boolean>> userToUpdate = null;
        if (user != null) {
            userToUpdate = (u -> {
                userRepository.saveAndFlush(u);
                return Optional.of(true);
            });
        }
        return Optional.of(userToUpdate.apply(user)).get();
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
