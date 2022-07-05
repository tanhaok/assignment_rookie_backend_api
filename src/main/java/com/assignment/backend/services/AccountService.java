package com.assignment.backend.services;

import java.util.List;

import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.response.AccountResponseDto;
import com.assignment.backend.dto.response.MessageResponse;

public interface AccountService {
    public List<AccountResponseDto> getAllAccount();

    public AccountResponseDto getAccountById(int id);

    public MessageResponse deleteAccount(int id);

    public MessageResponse updateAccount(int id, RegisterRequestDto dto);
}
