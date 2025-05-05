package com.example.userservice.Controllers;
import com.example.userservice.Model.Token;
import com.example.userservice.Model.User;
import com.example.userservice.Services.UserService;
import com.example.userservice.dtos.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.userservice.dtos.SignupRequestDTO;
import com.example.userservice.dtos.LoginRequestDTO;

@RestController
public class UserController
{
    UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserDTO signUp(@RequestBody SignupRequestDTO signupRequestDto)
    {
        User user = userService.signup(signupRequestDto.getName(),
                signupRequestDto.getEmail(),
                signupRequestDto.getPassword());

        return UserDTO.from(user);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDto)
    {
        Token token = userService.login(loginRequestDto.getEmail(),
                loginRequestDto.getPassword());

        LoginResponseDTO loginResponseDto = new LoginResponseDTO();
        loginResponseDto.setTokenValue(token.getValue());
        return loginResponseDto;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDTO logoutRequestDto)
    {
        return null;
    }

    @GetMapping("/validate/{token}")
    public ResponseEntity<Boolean> validateToken(@PathVariable("token") String token)
    {
        User user = userService.validateToken(token);
        ResponseEntity<Boolean> responseEntity;

        if(user == null)
        {
            responseEntity = new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        }
        else
        {
            responseEntity = new ResponseEntity<>(true, HttpStatus.OK);
        }

        return responseEntity;
    }
}