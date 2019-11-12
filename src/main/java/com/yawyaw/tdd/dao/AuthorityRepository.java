package com.example.demo.dao;

import com.example.demo.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
