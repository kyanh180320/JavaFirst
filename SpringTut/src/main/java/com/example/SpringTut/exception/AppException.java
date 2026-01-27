package com.example.SpringTut.exception;

import lombok.Getter;

//import ch.qos.logback.core.spi.ErrorCodes;
@Getter
public class AppException extends RuntimeException{

    private ErrorCode errorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }



}