package com.example.E_commerce.exception;

import com.example.E_commerce.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exc) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exc.getMessage());
        apiResponse.setData(null);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleException(Exception exc) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(exc.getMessage());
        apiResponse.setData(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiResponse);
    }
}
