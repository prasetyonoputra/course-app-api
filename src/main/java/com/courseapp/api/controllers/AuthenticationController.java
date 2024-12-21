package com.courseapp.api.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.courseapp.api.dto.requests.LoginRequestDto;
import com.courseapp.api.dto.requests.RegisterRequestDto;
import com.courseapp.api.services.AuthenticationService;
import com.courseapp.api.utilities.BaseAppController;
import com.courseapp.api.utilities.BaseResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController extends BaseAppController {
    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse> register(
            @RequestParam(required = false, name = "image_profile") MultipartFile imageProfile,
            @RequestParam(name = "first_name") String firstName, @RequestParam(name = "last_name") String lastName,
            @RequestParam(name = "email") String email, @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password) {

        RegisterRequestDto registerRequest = new RegisterRequestDto();
        registerRequest.setImageProfile(imageProfile);
        registerRequest.setFirstName(firstName);
        registerRequest.setLastName(lastName);
        registerRequest.setEmail(email);
        registerRequest.setUsername(username);
        registerRequest.setPassword(password);

        try {
            return toResponse(authenticationService.registerUser(registerRequest), "Registration successfully!");
        } catch (Exception e) {
            return toResponse(e);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> login(@RequestBody LoginRequestDto request) {
        try {
            return toResponse(authenticationService.loginUser(request), "Login successfully!");
        } catch (Exception e) {
            return toResponse(e);
        }
    }

    @PostMapping("/check-token")
    public ResponseEntity<BaseResponse> checkToken(@RequestBody Map<String, String> request) {
        try {
            return toResponse(authenticationService.checkToken(request), "Token valid!");
        } catch (Exception e) {
            return toResponse(e);
        }
    }
}