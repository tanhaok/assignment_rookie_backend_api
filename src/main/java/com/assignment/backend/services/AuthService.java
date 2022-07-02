package com.assignment.backend.services;

import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.dto.response.AccountResponseDto;
import com.assignment.backend.dto.response.AuthResponseDto;

import java.util.List;

import com.assignment.backend.dto.request.RegisterRequestDto;

public interface AuthService {
    public AuthResponseDto signIn(SignInRequestDto dto);

    public AuthResponseDto registerUser(RegisterRequestDto dto);
}
