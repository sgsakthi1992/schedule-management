package com.example.schedulemanagement.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public final ResponseEntity<ErrorDetails> constraintViolationException(
            final ConstraintViolationException e, final WebRequest webRequest) {
        var errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), webRequest.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDetails);
    }

    @ExceptionHandler(value = {ScheduleIdNotFoundException.class})
    public final ResponseEntity<ErrorDetails> scheduleIdNotFoundException(
            final ScheduleIdNotFoundException e, final WebRequest webRequest) {
        var errorDetails = new ErrorDetails(LocalDateTime.now(), e.getMessage(), webRequest.getDescription(false) + " " + ((ServletWebRequest) webRequest).getHttpMethod().name());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);
    }
}
