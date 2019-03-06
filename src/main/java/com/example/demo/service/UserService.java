package com.example.demo.service;

import com.example.demo.entities.User;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Adservio on 07/12/2018.
 */
public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    Boolean create(User user);

    /**
     *
     * @param user
     * @return
     */
    Boolean update(User user);

    /**
     *
     * @param user
     * @return
     */
    Boolean delete(User user);

    /**
     *
     * @param id
     * @return
     */
    Optional<User> findById(Long id);

    /**
     *
     * @param username
     * @return
     */
    Optional<User> findUserByUsername(String username);

    /**
     *
     * @return
     */
    Stream<User> findUsers();
}
