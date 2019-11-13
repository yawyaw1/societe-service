package com.societe.service.service;

import com.societe.service.entities.Employee;
import com.societe.service.entities.User;

import java.util.List;
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
