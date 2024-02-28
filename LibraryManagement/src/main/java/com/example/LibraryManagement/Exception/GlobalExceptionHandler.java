package com.example.LibraryManagement.Exception;

import com.example.LibraryManagement.Exception.CustomException.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    ErrorMsg errorMsg = new ErrorMsg();



    @ExceptionHandler( NotFoundException.class)
    public ResponseEntity<ErrorMsg> notFoundException(NotFoundException e, WebRequest webRequest){

        errorMsg.setMessage(e.getMessage());
        errorMsg.setPath(webRequest.getDescription(false));
        errorMsg.setStatus(e.getHttpStatus().value());
        errorMsg.setTimestamp(LocalDateTime.now());
        errorMsg.setError(e.getHttpStatus().name());
        return new ResponseEntity<>(errorMsg,e.getHttpStatus());
    }
}
