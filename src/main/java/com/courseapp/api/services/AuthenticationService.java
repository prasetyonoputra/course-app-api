package com.courseapp.api.services;

import java.util.Map;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.courseapp.api.dto.requests.LoginRequestDto;
import com.courseapp.api.dto.requests.RegisterRequestDto;
import com.courseapp.api.dto.responses.AuthenticationResponse;

@Service
public interface AuthenticationService extends UserDetailsService {
    AuthenticationResponse registerUser(RegisterRequestDto registerRequest) throws Exception;

    AuthenticationResponse loginUser(LoginRequestDto request);

    Map<String, Boolean> checkToken(Map<String, String> request) throws Exception;
}