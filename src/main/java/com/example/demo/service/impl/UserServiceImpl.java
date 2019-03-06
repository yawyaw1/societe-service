package com.example.demo.service.impl;

import com.example.demo.dao.RoleRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Adservio on 07/12/2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Boolean create(User user) {
        if (user != null) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encryptPwd=bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptPwd);

            List<Role> roles = new ArrayList<>(1);
            roles.add(new Role("USER"));

            roleRepository.saveAll(roles);

            user.setRoles(roles);
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
        if (id != null) {
            return userRepository.findById(id);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        if (!StringUtils.isEmpty(username)) {
            return userRepository.findUserByUsername(username);
        }
        return Optional.empty();
    }

    @Override
    public Stream<User> findUsers() {
        return userRepository.findAll().stream();
    }
}
