package com.example.userservice.Security.services;

import com.example.userservice.Model.User;
import com.example.userservice.Repositories.UserRepository;
import com.example.userservice.Security.models.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<User> optionalUser = userRepository.findByEmail(username);

        if(optionalUser.isEmpty())
        {
            throw new UsernameNotFoundException("User not found");
        }

        User user = optionalUser.get();

        return new CustomUserDetail(user);
    }
}