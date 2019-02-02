package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Adservio on 07/12/2018.
 */

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks
    private UserService userService=new UserServiceImpl();

    @Mock
    private UserRepository userRepository;

    private User user;
    private List<User> users;

    @Before
    public void init(){
        users=new ArrayList<>();
        user =new User();
        user.setCreationDate(LocalDate.now());
        user.setVersion("version");
        users.add(user);
    }

    @Test
    public void should_create_user_test() throws Exception {
        Boolean insert= userService.create(user);
        assertNotNull(insert);
        assertEquals(true,insert);
        assertTrue(insert);

    }

    @Test
    public void should_update_an_existing_user_test() throws Exception {

        User userToBeUpdated=new User();
        userToBeUpdated.setVersion("new vesrion");

        when(userRepository.saveAndFlush(user)).thenReturn(userToBeUpdated);

        Optional<Boolean> userToUpdate=userService.update(user);
        assertNotNull(userToUpdate);
        assertEquals(true,userToUpdate.get());

    }

    @Test
    public void should_delete_an_existing_user_test() throws Exception {

    }

    @Test
    public void should_return_an_existing_user_test() throws Exception {

    }
}