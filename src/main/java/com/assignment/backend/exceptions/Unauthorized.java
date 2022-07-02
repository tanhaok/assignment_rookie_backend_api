package com.assignment.backend.exceptions;

public class Unauthorized extends RuntimeException {
    public Unauthorized() {
        super();
    }

    public Unauthorized(String mess) {
        super(mess);
    }

    public Unauthorized(String mess, Throwable cause) {
        super(mess, cause);
    }
}
