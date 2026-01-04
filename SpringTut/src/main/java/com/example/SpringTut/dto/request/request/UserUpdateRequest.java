package com.example.SpringTut.dto.request.request;

import jakarta.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class UserUpdateRequest {
    
    @Size(max = 100, message = "fullname must not exceed 100 characters")
    private String fullname;
    
    @Size(min = 10, max = 10, message = "phone_number must be exactly 10 characters")
    private String phoneNumber;
    
    @Size(max = 200, message = "address must not exceed 200 characters")
    private String address;
    
    @Size(max = 100, message = "password must not exceed 100 characters")
    private String password;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    private Boolean isActive;
    
    private Integer facebookAccountId;
    
    private Integer googleAccountId;

    // Getters and Setters
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getFacebookAccountId() {
        return facebookAccountId;
    }

    public void setFacebookAccountId(Integer facebookAccountId) {
        this.facebookAccountId = facebookAccountId;
    }

    public Integer getGoogleAccountId() {
        return googleAccountId;
    }

    public void setGoogleAccountId(Integer googleAccountId) {
        this.googleAccountId = googleAccountId;
    }
}
