package com.example.userservice.Services;

import com.example.userservice.Model.Token;
import com.example.userservice.Model.User;

public interface UserService
{
    User signup(String name, String email, String password);
    Token login(String email, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);
}