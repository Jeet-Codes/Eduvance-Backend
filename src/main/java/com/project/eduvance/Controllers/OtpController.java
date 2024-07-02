package com.project.eduvance.Controllers;

import com.project.eduvance.Dto.OtpRequest;
import com.project.eduvance.Service.ServiceImp.OtpService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/eduvance/otp/")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("request")
    public ResponseEntity<String> generateOtp(@RequestBody OtpRequest otpRequest) {
        return otpService.sendOtp(otpRequest);
    }
}
