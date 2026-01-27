package com.example.SpringTut.dto.request.request;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // field nào null thì không hiện
public class ApiResponse<T> {
    private  int code;
    private  String message;
    private T result;

}
