package com.project.eduvance.Service;


import com.project.eduvance.Dto.ApiResponse;

public interface UserMethods {
    ApiResponse login(String userid, String password);

    ApiResponse forgot(String email, String password);

    boolean userExists(String email);
}
