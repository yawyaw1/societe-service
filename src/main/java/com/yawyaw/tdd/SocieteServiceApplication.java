package com.yawyaw.tdd;

import com.yawyaw.tdd.dao.CompanyRepository;
import com.yawyaw.tdd.entities.User;
import com.yawyaw.tdd.service.UserService;
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
    CommandLineRunner runner(UserService userService, CompanyRepository companyRepository){
        return args-> Stream.of(new User("firstname1", "lastname1", "username1", "password1"))
                .forEach(userService::create);
    }

}
