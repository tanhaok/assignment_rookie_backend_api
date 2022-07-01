package com.assignment.backend.dto.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class RegisterRequestDto {

    @NotBlank(message = "Username is required!")
    private String username;

    @NotBlank(message = "Password is required!")
    private String password;

    /**
     * @param username
     * @param password
     * @param address
     * @param email
     * @param phone
     */
    public RegisterRequestDto(@NotBlank(message = "Username is required!") String username,
            @NotBlank(message = "Password is required!") String password,
            @NotBlank(message = "Address is required!") String address,
            @NotBlank(message = "Email is required!") String email,
            @NotBlank(message = "Phone is required!") String phone) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }

    @NotBlank(message = "Address is required!")
    private String address;

    @NotBlank(message = "Email is required!")
    private String email;

    @NotBlank(message = "Phone is required!")
    private String phone;

    /**
     * 
     */
    public RegisterRequestDto() {
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

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

}
