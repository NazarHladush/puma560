package com.ua.lviv.iot.puma560.exeption;

public class InvalidEmailException extends RuntimeException {

    public InvalidEmailException(String message) {
        super(message);
    }
}
