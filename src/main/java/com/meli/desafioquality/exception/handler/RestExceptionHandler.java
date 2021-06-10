package com.meli.desafioquality.exception.handler;

import com.meli.desafioquality.exception.DefaultException;
import com.meli.desafioquality.exception.model.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        var response = new ErrorResponse();

        fieldErrors.forEach(e -> {
            String message = e.getDefaultMessage();
            response.getErrors().add(new ErrorResponse(e.getField(), message));
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DefaultException.class)
    public ResponseEntity<ErrorResponse> restException(DefaultException exception){
        ErrorResponse response = ErrorResponse.builder()
                                                .code(HttpStatus.BAD_REQUEST.toString())
                                                .message(exception.getMessage())
                                                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
