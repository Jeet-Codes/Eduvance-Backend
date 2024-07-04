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
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMessageBody());


            javaMailSender.send(mimeMessage);
            log.info("Email sent successfully to " + emailDetails.getRecipient());
            log.info("Email sender " + emailSender);


        }catch (MailException | MessagingException e) {
            throw new RuntimeException(e);
        }
    }





}
