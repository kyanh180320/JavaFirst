package com.example.SpringTut.dto;



import com.example.SpringTut.model.User;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private String name;
    private String email;


    public User convertToModel(){
        return User.builder().name(name).email(email).build();
    }
}