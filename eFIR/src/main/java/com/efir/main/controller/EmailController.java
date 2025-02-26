package com.efir.main.controller;

import com.efir.main.service.EmailSenderService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmailController {

    @Autowired
    private EmailSenderService emailSenderService;
    public String sendEmail(String toEmail,
                            String subject,
                            String body) {
        try {
            emailSenderService.sendEmail(toEmail, body, subject);
            return "Email sent successfully to " + toEmail;
        } catch (MessagingException e) {
            return "Error sending email: " + e.getMessage();
        }
    }
}
