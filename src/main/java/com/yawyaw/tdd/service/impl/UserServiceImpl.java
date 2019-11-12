package com.yawyaw.tdd.service.impl;

import com.yawyaw.tdd.dao.AuthorityRepository;
import com.yawyaw.tdd.dao.UserRepository;
import com.yawyaw.tdd.entities.Authority;
import com.yawyaw.tdd.entities.User;
import com.yawyaw.tdd.exception.UserNotFoundException;
import com.yawyaw.tdd.exception.UserValidationException;
import com.yawyaw.tdd.service.UserService;
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
        throw new UserValidationException("Validation problem");
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
        throw new UserNotFoundException("User not found");

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
