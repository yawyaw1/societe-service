package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by Adservio on 07/12/2018.
 */

@RunWith(SpringRunner.class)
@Rollback(value = true)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;
    private User user;

    @Before
    public void init(){
        user =new User();
        user.setCreationDate(LocalDate.now());
        user.setVersion("version");
    }

    @Test
    public void testCreate() throws Exception {
        Boolean insert= userService.create(user);
        assertNotNull(insert);
        assertEquals(true,insert);
        assertTrue(insert);

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {

    }
}