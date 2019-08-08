package com.example.demo.Exception;

public class TemporaryUserNotFoundException extends RuntimeException {
    public TemporaryUserNotFoundException(String message) {
        super(message);
    }
    public TemporaryUserNotFoundException() {
        super();
    }
}

