package com.medivault.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {
    public ValidationException() { super(); }
    public ValidationException(String msg) { super(msg); }
    public ValidationException(String msg, Throwable t) { super(msg, t); }
}
