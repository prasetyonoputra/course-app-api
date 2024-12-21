package com.courseapp.api.dto.requests;

import org.springframework.web.multipart.MultipartFile;

public class RegisterRequestDto {
    private MultipartFile imageProfile;

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    public MultipartFile getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(MultipartFile imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
