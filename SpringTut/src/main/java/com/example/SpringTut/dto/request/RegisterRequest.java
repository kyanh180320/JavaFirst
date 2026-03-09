package com.example.SpringTut.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    @NotBlank(message = "Username không được để  trống")
    @Size(min=3, max=50, message = "Username từ 3 đn 50 ký tự")
    @Pattern(regexp = "^[a-z0-9_]+$",
            message = "Username ch")
    private String username;
    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(max=100)
    private String email;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min=8, max=100, message = "Mật khẩu tối thiểu 8 ký tự")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Mật khẩu phải có chữ hoa, chữ thường và kí tự đặc biệt")
    private String password;
    @NotBlank(message = "Họ tên không được để trống")
    @Size(min=2, max=100)
    private String fullName;
}

