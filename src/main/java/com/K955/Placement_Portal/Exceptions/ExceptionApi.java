package com.K955.Placement_Portal.Exceptions;

import org.springframework.http.HttpStatus;

import java.time.Instant;

public record ExceptionApi(
        HttpStatus status,
        String message,
        Instant timestamp
) {
}
