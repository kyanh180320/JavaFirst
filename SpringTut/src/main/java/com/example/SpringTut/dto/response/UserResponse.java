package com.example.SpringTut.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    private Long id;

    private String email;

    private String fullName;

    private List<String> roles;
}
