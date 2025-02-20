package com.security.sinkingship.service;

import com.security.sinkingship.model.Users;
import com.security.sinkingship.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo repo;

    private final PasswordEncoder encoder;

    public Users register(Users users) {
        users.setPassword(encoder.encode(users.getPassword()));
        return repo.save(users);
    }
}
