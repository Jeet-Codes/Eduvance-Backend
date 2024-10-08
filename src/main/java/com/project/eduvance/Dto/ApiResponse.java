package com.project.eduvance.Dto;

import com.project.eduvance.Entity.User;
import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;
    private User user;



    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }



}



