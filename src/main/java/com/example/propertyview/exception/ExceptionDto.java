package com.example.propertyview.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;

@Getter
@Builder
public class ExceptionDto {

    private final int status;
    private final String error;
    private final String message;
    private final Instant timestamp;

    public static ExceptionDto of(HttpStatus status, String message) {
        return ExceptionDto.builder()
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(message)
                .timestamp(Instant.now())
                .build();
    }

    public static ResponseEntity<ExceptionDto> buildResponse(HttpStatus status, String message) {
        return ResponseEntity
                .status(status)
                .body(of(status, message));
    }
}