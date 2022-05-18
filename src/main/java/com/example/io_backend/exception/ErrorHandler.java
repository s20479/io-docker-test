package com.example.io_backend.exception;


import org.keycloak.authorization.client.util.Http;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {
    private final Map<String, Object> errorMsg = new LinkedHashMap<>();

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleError(BadRequestException e) {
        errorMsg.clear();
        errorMsg.put("status", HttpStatus.BAD_REQUEST);
        errorMsg.put("msg", e.getMessage());

        return errorMsg;
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleError(InternalServerErrorException e) {
        errorMsg.clear();
        errorMsg.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        errorMsg.put("msg", e.getMessage());

        return errorMsg;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleError(NotFoundException e) {
        errorMsg.clear();
        errorMsg.put("status", HttpStatus.NOT_FOUND);
        errorMsg.put("msg", e.getMessage());

        return errorMsg;
    }
}
