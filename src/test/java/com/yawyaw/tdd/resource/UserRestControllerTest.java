package com.yawyaw.tdd.resource;

import com.yawyaw.tdd.SocieteServiceApplication;
import com.yawyaw.tdd.entities.User;
import com.yawyaw.tdd.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
/**
 * Created by Adservio on 06/03/2019.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SocieteServiceApplication.class)
public class UserRestControllerTest {

    private static final String URL_USER = "http://localhost:1111/users";

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Autowired
    private UserService userService;

    private MockRestServiceServer mockServer;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void init() {
        mockServer = MockRestServiceServer.createServer(restTemplate());
    }

    @Test
    public void testFetchUsers() throws Exception {
        User user = new User("firstname1", "lastname1", "username1", "password1");
        mockServer.expect(ExpectedCount.once(), MockRestRequestMatchers.requestTo(new URI(URL_USER)))
                .andExpect(MockRestRequestMatchers.method(HttpMethod.GET))
                .andRespond(MockRestResponseCreators.withStatus(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(mapper.writeValueAsString(user)));
        User userToFind = userService.findById(1L).get();

        assertNotNull(userToFind);
//        assertEquals(user, userToFind);

    }
}