package com.assignment.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.response.AccountResponseDto;
import com.assignment.backend.dto.response.MessageResponse;
import com.assignment.backend.services.AccountService;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public List<AccountResponseDto> getAllAccount() {
        return this.accountService.getAllAccount();
    }

    @GetMapping("/{id}")
    public AccountResponseDto getAccountById(@PathVariable int id) {
        return this.accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public MessageResponse updateAccount(@PathVariable int id, @Valid @RequestBody RegisterRequestDto dto) {
        return this.accountService.updateAccount(id, dto);
    }

    @PatchMapping("/{id}")
    public MessageResponse deleteAccount(@PathVariable int id) {
        return this.accountService.deleteAccount(id);
    }
}
