package com.example.SpringTut.dto.response;

public class ResponseError extends ResponseData {

    public ResponseError(int status, String message) {
        super(status, message);
    }
}