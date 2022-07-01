package com.assignment.backend.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.assignment.backend.dto.response.Error;
import com.assignment.backend.exceptions.ResourceAlreadyExistsException;
import com.assignment.backend.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionsHandler extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<Error> handleResourceNotFoundException(RuntimeException exception, WebRequest req){
        Error error = new Error("404", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ ResourceAlreadyExistsException.class })
    protected ResponseEntity<Error> handleResourceAlreadyExistsException(RuntimeException exception,
            WebRequest request) {
        Error error = new Error("400", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({IllegalArgumentException.class})
    protected ResponseEntity<Error> handleIllegalArgumentException(RuntimeException exception, WebRequest request){
        Error error = new Error("400", exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders header, HttpStatus status, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((err) -> {
            String field = ((FieldError)err).getField();
            String message = err.getDefaultMessage();
            errors.put(field, message);
        });

        Error error = new Error("404", "Validation Error", errors);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }

}
