package com.project.eduvance.Service.ServiceImp;

import com.project.eduvance.Dto.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String emailSender;

    public void sendSimpleMail(EmailDetails emailDetails) {
        try {
//            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom(emailSender);
//            message.setTo(emailDetails.getRecipient());
//            message.setText(emailDetails.getMessageBody());
//            message.setSubject(emailDetails.getSubject());

            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText("""
                    <div style="font-family: Arial, sans-serif; color: #333333; padding: 20px; background-color: #f4f4f4; border-radius: 10px;">
                                  <div style="background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0,0,0,0.1); text-align: center;">
                                      <h2 style="color: #0056b3;">Your Verification Code</h2>
                                      <p style="font-size: 18px; margin-bottom: 30px;">Please use the following One-Time Password (OTP) to complete your verification process:</p>
                                      <div style="font-size: 24px; font-weight: bold; color: #28a745; padding: 10px 20px; border: 2px dashed #28a745; display: inline-block; border-radius: 5px;">
                                          %s
                                      </div>
                                      <p style="margin-top: 30px; font-size: 14px; color: #555555;">If you did not request this code, please ignore this email or contact our support team.</p>
                                  </div>
                                  <div style="text-align: center; font-size: 12px; color: #888888; margin-top: 20px;">
                                      © 2024 Eduvance . All rights reserved.
                                  </div>
                          </div>
	        """.formatted(emailDetails.getOtp()),true);


            javaMailSender.send(mimeMessage);
            log.info("Email sent successfully to " + emailDetails.getRecipient());
            log.info("Email sender " + emailSender);


        }catch (MailException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }





}
