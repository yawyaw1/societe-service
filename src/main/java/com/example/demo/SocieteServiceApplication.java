package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class SocieteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocieteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args-> Stream.of(new User("firstname1", "lastname1", "username1", "password1"))
                .forEach(userService::create);
    }

}
