package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.EmailDetails;
import com.project.eduvance.Dto.OtpRequest;
import com.project.eduvance.Dto.OtpValidate;
import com.project.eduvance.Entity.Otp;
import com.project.eduvance.Repository.OtpRepo;
import com.project.eduvance.Utils.OtpGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
                .expiredAt(LocalDateTime.now().plusMinutes(5)) // expired at
                .build());

        emailService.sendSimpleMail(EmailDetails.builder()
                .subject("DO NOT DISCLOSE!!")
                .recipient(otpRequest.getEmail())
                .otp(otp)
                .build());

        return ResponseEntity.status(200).body("OTP sent successfully");
    }


    public ResponseEntity<String> validateOtp(OtpValidate otpValidate) {
        List<Otp> otps = otpRepo.findByEmailSortedByDate(otpValidate.getEmail());

        if (otps.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("OTP has not been sent for this email.");
        }

        Otp otp = otps.get(0);

        if (otp.getExpiredAt().isBefore(LocalDateTime.now())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The OTP has expired.");
        }

        if (!otp.getOtp().equals(otpValidate.getOtp())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Invalid OTP.");
        }

        return ResponseEntity.ok("OTP validated successfully.");
    }



}