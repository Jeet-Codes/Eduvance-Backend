package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.EmailDetails;
import com.project.eduvance.Dto.OtpRequest;
import com.project.eduvance.Dto.OtpValidate;
import com.project.eduvance.Entity.Otp;
import com.project.eduvance.Repository.OtpRepo;
import com.project.eduvance.Utils.OtpGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Slf4j
public class OtpService {


    @Autowired
    private OtpRepo otpRepo;
    @Autowired
    private EmailService emailService;

    public ResponseEntity<String> sendOtp(OtpRequest otpRequest) {
        String otp= OtpGenerator.generateOtp();
        log.info("OTP generated: {}",otp);
        otpRepo.save(Otp.builder()
                        .email(otpRequest.getEmail())
                        .otp(otp)
                        .createdAt(LocalDateTime.now())
                        .expiredAt(LocalDateTime.now().plusMinutes(5))
                .build());
        emailService.sendSimpleMail(EmailDetails.builder()
                        .subject("DO NOT DISCLOSE!!")
                        .recipient(otpRequest.getEmail())
                        .messageBody("The Otp for Reset the otp is: "+otp)

                .build());
        return ResponseEntity.status(200).body("OTP sent successfully");

    }


    public ResponseEntity<String> validateOtp(OtpValidate otpValidate) {
        Otp otp= otpRepo.findByEmail(otpValidate.getEmail());
        log.info("Email found: {}",otpValidate.getEmail());
        if(otp == null){
            return ResponseEntity.status(400)
                    .body("You have not sent an otp");
        }

        if(otp.getExpiredAt().isBefore(LocalDateTime.now())){
            return ResponseEntity.status(400)
                    .body("You have expired otp");
        }

        if(!otp.getOtp().equals(otpValidate.getOtp())){
            return ResponseEntity.status(400)
                    .body("OTP is Invalid");
        }

        return ResponseEntity.status(200).body("true");
    }


}
