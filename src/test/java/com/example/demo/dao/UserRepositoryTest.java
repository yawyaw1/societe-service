package com.example.demo.dao;

import com.example.demo.SocieteServiceApplication;
import com.example.demo.entities.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Adservio on 04/03/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocieteServiceApplication.class)
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private List<User> users;

    @Before
    public void init() {
        users = new ArrayList<>(4);

        User user1 = new User();
        user1.setFirstname("firstname1");

        User user2 = new User();
        user1.setFirstname("firstname2");

        User user3 = new User();
        user1.setFirstname("firstname3");

        User user4 = new User();
        user1.setFirstname("firstname4");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    @Test
    public void should_persist_user_to_db() {
        User user = new User();
        user.setFirstname("firstname");
        User userToPersist = userRepository.save(user);
        Assert.assertNotNull(userToPersist);
        Assert.assertEquals("firstname", userToPersist.getFirstname());
    }

    @Test
    public void should_retrieve_user_with_id() {
        User user = new User();
        user.setFirstname("firstname");
        userRepository.save(user);
        User userToFind = userRepository.findById(1L).get();
        Assert.assertNotNull(userToFind);
        Assert.assertEquals("firstname", userToFind.getFirstname());
    }

    @Test
    public void should_delete_user_by_id() {
        User user = new User();
        user.setFirstname("firstname");
        User userToPersist = userRepository.save(user);
        userRepository.deleteById(userToPersist.getId());
    }


    @Test
    public void should_retrieve_list_of_users() {

        Stream<User> userStream = userRepository.findAll().stream();
        Assert.assertEquals(0,userStream.count());
        Assert.assertNotNull(userStream);

    }


}