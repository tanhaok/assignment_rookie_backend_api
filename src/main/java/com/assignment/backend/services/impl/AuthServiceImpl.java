package com.assignment.backend.services.impl;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.backend.data.entities.Account;
import com.assignment.backend.data.repositories.AccountRepository;
import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.dto.response.AuthResponseDto;
import com.assignment.backend.exceptions.ResourceAlreadyExistsException;
import com.assignment.backend.exceptions.Unauthorized;
import com.assignment.backend.security.jwt.JwtUtils;
import com.assignment.backend.services.AuthService;
import com.assignment.backend.utils.Utils;

@Service
public class AuthServiceImpl implements AuthService {

    private AccountRepository accountRepository;
    private PasswordEncoder encoder;
    private JwtUtils jwtUtils;
    private ModelMapper modelMapper;

    @Autowired
    public AuthServiceImpl(AccountRepository accountRepository,
            PasswordEncoder passwordEncoder, JwtUtils jwtUtils, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.encoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
        this.modelMapper = modelMapper;
    }

    @Override
    public AuthResponseDto signIn(SignInRequestDto dto) {
        Account acc = this.accountRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new Unauthorized(Utils.ACCOUNT_NOT_FOUND));

        if (!encoder.matches(dto.getPassword(), acc.getPassword())) {
            throw new Unauthorized(Utils.WRONG_PASS);
        }

        if (!acc.isStatus()) {
            throw new Unauthorized(Utils.ACCOUNT_BLOCK);
        }
        String accessToken = this.jwtUtils.generateJwtToken(acc);
        AuthResponseDto res = this.modelMapper.map(acc, AuthResponseDto.class);
        res.setAccessToken(accessToken);
        return res;
    }

    @Override
    public AuthResponseDto registerUser(RegisterRequestDto dto) {

        // check user exists
        if (accountRepository.existsByUsername(dto.getUsername())) {
            throw new ResourceAlreadyExistsException(Utils.USERNAME_EXITS);
        }

        String tempPass = encoder.encode(dto.getPassword());
        dto.setPassword(tempPass);
        Account account = modelMapper.map(dto, Account.class);
        account.setRole("USER");
        account.setStatus(true);
        account.setCreateDate(new Date());
        account.setUpdateDate(new Date());
        this.accountRepository.save(account);
        AuthResponseDto res = modelMapper.map(account, AuthResponseDto.class);
        String access = jwtUtils.generateJwtToken(account);
        res.setAccessToken(access);
        return res;
    }

}
