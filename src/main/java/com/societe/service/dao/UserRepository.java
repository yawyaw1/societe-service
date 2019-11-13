package com.societe.service.dao;

import com.societe.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

/**
 * Created by Adservio on 07/12/2018.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     *
     * @param username
     * @return
     */
    Optional<User> findUserByUsername(String username);
}
