package com.assignment.backend.services;

import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.dto.response.AuthResponseDto;

public interface AuthService {
    public AuthResponseDto signIn(SignInRequestDto dto);

    public AuthResponseDto registerUser(RegisterRequestDto dto);
}
