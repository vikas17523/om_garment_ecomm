package com.ecommerce.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ecommerce.api.dto.BaseResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<BaseResponse> handleEmailException(EmailAlreadyExistsException ex) {

        BaseResponse response =new BaseResponse("FAILED", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(MobileAlreadyExistsException.class)
    public ResponseEntity<BaseResponse> handleMobileException(
            MobileAlreadyExistsException ex) {

        BaseResponse response = new BaseResponse("FAILED", ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<BaseResponse> handleUserNotFound(
            UserNotFoundException ex) {

        BaseResponse response =
                new BaseResponse("USER_NOT_FOUND", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    
    @ExceptionHandler(AuthenticationFailedException.class)
    public ResponseEntity<BaseResponse> handleAuthenticationFailed(
            AuthenticationFailedException ex) {

        BaseResponse response =
                new BaseResponse("AUTH_FAIL", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handleGenericException(Exception ex) {

        BaseResponse response = new BaseResponse("FAILED", "INTERNAL_SERVER_ERROR");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }
}