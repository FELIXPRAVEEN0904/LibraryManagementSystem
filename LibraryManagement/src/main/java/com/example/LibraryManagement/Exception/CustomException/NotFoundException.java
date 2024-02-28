package com.example.LibraryManagement.Exception.CustomException;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class NotFoundException extends Throwable {

     String message;

     HttpStatus httpStatus;

    public NotFoundException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
