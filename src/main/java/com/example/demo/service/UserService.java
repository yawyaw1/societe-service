package com.example.demo.service;

import com.example.demo.entities.User;

import java.util.Optional;

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
    Optional<Boolean> update(User user);

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
    User findById(Long id);

}
