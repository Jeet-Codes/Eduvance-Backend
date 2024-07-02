package com.project.eduvance.Utils;

import java.util.Random;

public class OtpGenerator {

    public static String generateOtp() {
        StringBuilder otp = new StringBuilder();
        Random random=new Random();
        while(otp.length()<4){
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

//    Testing the OTP Generator
    public static void main(String[] args) {
        System.out.println(generateOtp());
    }
}
