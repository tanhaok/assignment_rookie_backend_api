package com.assignment.backend.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class SignInRequestDto {
    @NotBlank
    private String username;

    @NotBlank
    @Min(8)
    @Max(30)
    private String password;

    /**
     * 
     */
    public SignInRequestDto() {
    }

    /**
     * @param username
     * @param password
     */
    public SignInRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
