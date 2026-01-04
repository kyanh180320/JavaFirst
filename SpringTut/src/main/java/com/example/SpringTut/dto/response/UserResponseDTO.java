package com.example.SpringTut.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "Response DTO for user information")
public class UserResponseDTO implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Schema(description = "User ID", example = "1")
    @JsonProperty("id")
    private Long id;
    
    @Schema(description = "User's first name", example = "Nguyen")
    @JsonProperty("firstName")
    private String firstName;
    
    @Schema(description = "User's last name", example = "Van A")
    @JsonProperty("lastName")
    private String lastName;
    
    @Schema(description = "User's full name", example = "Nguyen Van A")
    @JsonProperty("fullName")
    private String fullName;
    
    @Schema(description = "User's email address", example = "nguyenvana@example.com")
    @JsonProperty("email")
    private String email;
    
    @Schema(description = "User's phone number", example = "0912345678")
    @JsonProperty("phone")
    private String phone;
    
    @Schema(description = "User's status (active/inactive)", example = "true")
    @JsonProperty("status")
    private Boolean status;
    
    @Schema(description = "User creation timestamp")
    @JsonProperty("createdAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    
    @Schema(description = "User last update timestamp")
    @JsonProperty("updatedAt")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
