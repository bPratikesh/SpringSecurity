package com.pratikesh.SecurityApp.SecurityApplication.controller;

import com.pratikesh.SecurityApp.SecurityApplication.dto.LoginDto;
import com.pratikesh.SecurityApp.SecurityApplication.dto.SignUpDto;
import com.pratikesh.SecurityApp.SecurityApplication.dto.UserDto;
import com.pratikesh.SecurityApp.SecurityApplication.service.AuthService;
import com.pratikesh.SecurityApp.SecurityApplication.service.Serviceimpl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserServiceImpl userService;
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.signup(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);
        return ResponseEntity.ok(token);
    }

}
