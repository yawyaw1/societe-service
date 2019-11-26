package com.consulting.service.service;

import com.consulting.service.entities.User;

import java.util.List;

/**
 * Created by Adservio on 07/12/2018.
 */
public interface UserService {
    /**
     *
     * @param user
     * @return
     */
    User create(User user);

    /**
     *
     * @param user
     * @return
     */
    User update(User user);

    /**
     *
     * @param user
     * @return
     */
    User delete(User user);

    /**
     *
     * @param id
     * @return
     */
    User findById(Long id);

    /**
     *
     * @param username
     * @return
     */
    User findUserByUsername(String username);

    /**
     *
     * @return
     */
    List<User> findUsers();
}
