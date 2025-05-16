package org.example.exception;

import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException{

    private final HttpStatus status;

    public ServiceException(String message, Throwable cause, HttpStatus status) {
        super(message, cause);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
