package com.assignment.backend.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.response.AccountResponseDto;

public interface AccountService {
    public List<AccountResponseDto> getAllAccount();

    public AccountResponseDto getAccountById(int id);

    public ResponseEntity<?> deleteAccount(int id);

    public ResponseEntity<?> updateAccount(int id, RegisterRequestDto dto);
}
