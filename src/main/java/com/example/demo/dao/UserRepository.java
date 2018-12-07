package com.example.demo.dao;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

/**
 * Created by Adservio on 07/12/2018.
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User,Long> {
}
