package com.societe.service.resource;


import com.societe.service.entities.User;
import com.societe.service.exception.NotFoundException;
import com.societe.service.exception.ValidationException;
import com.societe.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> fetchUsers() {
        List<User> users = userService.findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> createUser(@Valid User user) {
        User u = userService.create(user);
        if(null != u){
            return new ResponseEntity<>(u,HttpStatus.OK);
        }
        throw new ValidationException();
    }

    @GetMapping("/findById/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }


}
