package com.societe.service.service.impl;


import com.societe.service.enums.ErrorMessage;
import com.societe.service.exception.NotFoundException;
import com.societe.service.dao.AuthorityRepository;
import com.societe.service.dao.UserRepository;
import com.societe.service.entities.Authority;
import com.societe.service.entities.User;
import com.societe.service.exception.ValidationException;
import com.societe.service.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public User create(User user) {
        if (user.getFirstname() != null) {
           /* BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String encryptPwd = bCryptPasswordEncoder.encode(user.getPassword());
            user.setPassword(encryptPwd);*/

            List<Authority> authorities = new ArrayList<>(1);
            authorities.add(new Authority("USER"));

            authorityRepository.saveAll(authorities);

            user.setAuthorities(authorities);
            userRepository.saveAndFlush(user);

            return user;
        }
        throw new ValidationException(ErrorMessage.LOG002_MSG.getName() + user);
    }

    @Override
    public User update(User user) {
        if (user != null) {
            return userRepository.saveAndFlush(user);
        } else {
            throw new ValidationException(ErrorMessage.LOG002_MSG.getName() + user);
        }
    }

    @Override
    public User delete(User user) {
        if (user != null) {
            userRepository.delete(user);
            return user;
        } else {
            throw new ValidationException(ErrorMessage.LOG002_MSG.getName() + user);
        }
    }

    @Override
    public User findById(Long id) {
        if (null != id) {
            return userRepository.findById(id).orElseThrow(() -> new ValidationException(ErrorMessage.LOG002_MSG.getName() + id));
        }
        return null;

    }

    @Override
    public User findUserByUsername(String username) {
        if (!StringUtils.isEmpty(username)) {
            return userRepository.findUserByUsername(username).orElseThrow(() -> new NotFoundException(username + ErrorMessage.LOG003_MSG.getName()));
        }
        return null;
    }

    @Override
    public List<User> findUsers() {
        return userRepository.findAll();
    }
}
