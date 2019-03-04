package com.example.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Adservio on 04/03/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserRepository.class)
@ComponentScan(basePackages = "com.example.demo.dao")
@ContextConfiguration(classes = UserRepository.class)
public class UserRepositoryTest {

    @Test
    public void should_persist_user_to_db(){

    }

}