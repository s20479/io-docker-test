package com.example.io_backend.exception;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class HttpException extends RuntimeException {
    private HttpStatus httpStatus;
    private String msg;
    public HttpException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
