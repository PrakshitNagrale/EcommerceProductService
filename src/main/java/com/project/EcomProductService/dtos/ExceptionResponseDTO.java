package com.project.EcomProductService.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponseDTO {

    private String message;
    private int status;
    private LocalDateTime timeStamp = LocalDateTime.now();

    public ExceptionResponseDTO(String message, int code) {
        this.message = message;
        this.status = code;
    }
}
