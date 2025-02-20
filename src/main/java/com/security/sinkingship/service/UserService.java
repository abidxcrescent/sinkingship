package com.security.sinkingship.service;

import com.security.sinkingship.model.Users;
import com.security.sinkingship.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    public Users register(Users users) {
        repo.save(users);
        return users;
    }

    /*
        Passing un authenticated and marking it as authenticated
     */
    public String verify(Users user) {
        Authentication authentication =
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        user.getUsername(), user.getPassword()));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getUsername());
        }
        else{
            return "fail";
        }
    }
}
