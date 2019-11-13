package com.societe.service.service;

import com.societe.service.entities.User;

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
    Optional<User> create(User user);

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
