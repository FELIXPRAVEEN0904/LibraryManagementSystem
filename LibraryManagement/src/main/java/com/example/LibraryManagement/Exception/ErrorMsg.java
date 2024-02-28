package com.example.LibraryManagement.Exception;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ErrorMsg {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;
    private String message;
}
