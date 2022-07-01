package com.assignment.backend.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.backend.dto.request.SignInRequestDto;
import com.assignment.backend.exceptions.ResourceAlreadyExistsException;
import com.assignment.backend.exceptions.ResourceNotFoundException;
import com.assignment.backend.security.jwt.JwtUtils;
import com.assignment.backend.data.entities.Account;
import com.assignment.backend.data.entities.Role;
import com.assignment.backend.data.entities.TypeRole;
import com.assignment.backend.data.repositories.AccountRepository;
import com.assignment.backend.data.repositories.RoleRepository;
import com.assignment.backend.dto.request.RegisterRequestDto;
import com.assignment.backend.services.AuthService;
import com.assignment.backend.utils.Message;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String signIn(SignInRequestDto dto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(),
                        dto.getPassword()));

        // if correct
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtUtils.generateJwtToken(authentication);
    }

    @Override
    public String registerUser(RegisterRequestDto dto) {

        // check user exists
        if (accountRepository.existsByUsername(dto.getUsername())) {
            throw new ResourceAlreadyExistsException(Message.USERNAME_EXITS);
        }

        System.out.println(dto.getPassword());
        String tempPass = encoder.encode(dto.getPassword());
        dto.setPassword(tempPass);
        Account account = modelMapper.map(dto, Account.class);

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByRole(TypeRole.ROLE_USER)
                .orElseThrow(() -> new ResourceNotFoundException(Message.ROLE_NOT_FOUND));
        roles.add(userRole);

        this.accountRepository.save(account);

        return null;
    }

}
