package com.example.demo.Exceptions;

public class AuthorHasBooksException extends RuntimeException{
    public AuthorHasBooksException(String message) {
        super(message);
    }
}
