package ru.andersen.library.exceptions;

import javax.naming.AuthenticationException;

public class AuthorizationException extends AuthenticationException {
    public AuthorizationException(String text) {
        super(text);
    }

    public AuthorizationException() {
    }
}
