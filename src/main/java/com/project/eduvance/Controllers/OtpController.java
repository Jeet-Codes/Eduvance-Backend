package com.project.eduvance.Controllers;

import com.project.eduvance.Dto.OtpRequest;
import com.project.eduvance.Dto.OtpValidate;
import com.project.eduvance.Service.ServiceImp.OtpService;
import com.project.eduvance.Service.ServiceImp.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/eduvance/otp")
@CrossOrigin("*")
public class OtpController {

    @Autowired
    private OtpService otpService;
    @Autowired
    private UserService userService;
    @PostMapping("/request")
    public ResponseEntity<String> generateOtp(@RequestBody OtpRequest otpRequest) {
        boolean userExists = userService.userExists(otpRequest.getEmail());
        if (userExists) {
            otpService.sendOtp(otpRequest);
            return new ResponseEntity<>("OTP sent successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestBody OtpValidate otpValidate) {
        return otpService.validateOtp(otpValidate);
    }

}