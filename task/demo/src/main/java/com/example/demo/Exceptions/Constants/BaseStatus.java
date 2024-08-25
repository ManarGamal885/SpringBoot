package com.example.demo.Exceptions.Constants;

public enum BaseStatus {
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500),

    AUTHOR_HAS_BOOKS(600);
    private final int code;

    // Constructor
    BaseStatus(int code) {
        this.code = code;
    }

    // Getter method to access the code
    public int getCode() {
        return code;
    }
}
