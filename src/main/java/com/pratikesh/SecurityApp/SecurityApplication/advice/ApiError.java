package com.pratikesh.SecurityApp.SecurityApplication.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;


@Data
public class ApiError {

    private LocalDateTime timeStamp;
    private HttpStatus status;
    private String error;

    public ApiError() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String error) {
        this();
        this.status = status;
        this.error = error;
    }
}