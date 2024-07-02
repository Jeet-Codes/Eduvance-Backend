package com.project.eduvance.Controllers;


import com.project.eduvance.Dto.ApiResponse;
import com.project.eduvance.Entity.User;
import com.project.eduvance.Service.UserMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/eduvance/user")
public class UserController {
    @Autowired
    private UserMethods userMethods;
    @PostMapping("/login")
    public ResponseEntity<?>loginUser(@RequestBody User user) {
        ApiResponse login = userMethods.login(user.getUserEmail(), user.getUserPasswd());
        return ResponseEntity.ok(login);
    }


    @PostMapping()
    public ResponseEntity<?>forgetPassword(@RequestBody User user) {  //
        ApiResponse forgot = userMethods.forgot(user.getUserEmail(), user.getUserPasswd());
        return ResponseEntity.ok(forgot);

    }
}
