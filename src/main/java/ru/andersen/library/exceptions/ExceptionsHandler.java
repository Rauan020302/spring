package ru.andersen.library.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(value = {ObjectsNotFoundException.class})
    public ResponseEntity<Object> handleApiRequestException(ObjectsNotFoundException e){
        HttpStatus badRequest = HttpStatus.NOT_FOUND;
        Exception exception = new Exception(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception,badRequest);
    }
    @ExceptionHandler(value = {AuthorizationException.class})
    public ResponseEntity<Object> handleApiRequestException(AuthorizationException e){
        HttpStatus badRequest = HttpStatus.FORBIDDEN;
        Exception exception = new Exception(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(exception,badRequest);
    }
}
