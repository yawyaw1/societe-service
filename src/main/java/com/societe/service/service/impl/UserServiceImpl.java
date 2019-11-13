package com.societe.service.service.impl;


import com.societe.service.exception.NotFoundException;
import com.societe.service.dao.AuthorityRepository;
import com.societe.service.dao.UserRepository;
import com.societe.service.entities.Authority;
import com.societe.service.entities.User;
import com.societe.service.exception.ValidationException;
import com.societe.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private AuthorityRepository authorityRepository;

    @Override
    public Optional<User> create(User user) {
        if (user.getFirstname() != null) {
           /* BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encryptPwd = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptPwd);*/

            List<Authority> authorities = new ArrayList<>(1);
            authorities.add(new Authority("USER"));

            authorityRepository.saveAll(authorities);

            user.setAuthorities(authorities);
            userRepository.saveAndFlush(user);

            return Optional.of(user);
        }
        throw new ValidationException("Validation problem");
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
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            return byId;
        }
        throw new NotFoundException("User not found");

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
