package com.example.schedulemanagement.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class ErrorDetails {
    private final LocalDateTime timestamp;
    private final String message;
    private final String details;
}