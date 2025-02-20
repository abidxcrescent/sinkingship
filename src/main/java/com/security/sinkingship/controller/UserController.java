package com.security.sinkingship.controller;


import com.security.sinkingship.model.Users;
import com.security.sinkingship.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users){
        return userService.register(users);
    }

}
