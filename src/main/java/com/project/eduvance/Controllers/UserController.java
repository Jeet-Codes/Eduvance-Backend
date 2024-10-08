package com.project.eduvance.Controllers;


import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/eduvance/user")
public class UserController {
    @Autowired
    private UserMethods userMethods;

    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestParam("username") String username,
                                       @RequestParam("password") String password) {
        ApiResponse login = userMethods.login(username, password);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }


    @PostMapping("/update")
    public ResponseEntity<ApiResponse>forgetPassword(@RequestParam("email") String email,
                                           @RequestParam("password") String password) {  //
        ApiResponse forgot = userMethods.forgot(email, password);
        return new ResponseEntity<>(forgot, HttpStatus.OK);

    }
}
