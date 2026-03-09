package com.example.SpringTut.dto.response;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private Long userId;
    private String username;
    private String email;
    private String fullName;
    
    //dùng cho login
    private String accessToken;
    private String refreshToken;
}
