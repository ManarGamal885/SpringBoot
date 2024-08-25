package com.example.demo.Exceptions.DTOs;

import com.example.demo.Exceptions.Constants.BaseStatus;

public record AuthorHasBooksExceptionDto(String message, Integer status) {
    public AuthorHasBooksExceptionDto(String message) {
        this(message, BaseStatus.AUTHOR_HAS_BOOKS.getCode());
    }
}