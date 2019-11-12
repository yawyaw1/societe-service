package com.yawyaw.tdd.dao;

import com.yawyaw.tdd.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

}
