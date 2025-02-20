package com.security.sinkingship.service;

import com.security.sinkingship.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.security.sinkingship.model.Users;
import com.security.sinkingship.model.UserPrincipal;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService{

    private final UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);

    }
}
