package com.example.user.exception;

import org.springframework.http.HttpStatus;

public class UserNotExistException extends GenericException {
    public UserNotExistException(Integer userId) {
        super(HttpStatus.NOT_FOUND, String.format("user not exist, user id: %s", userId));
    }
}
