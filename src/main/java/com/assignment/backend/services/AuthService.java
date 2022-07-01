package com.assignment.backend.services;

import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.dto.request.RegisterRequestDto;

public interface AuthService {
    public String signIn(SignInRequestDto dto);
    public String registerUser(RegisterRequestDto dto);
}
