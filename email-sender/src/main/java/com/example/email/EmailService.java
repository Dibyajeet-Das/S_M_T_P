package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String to, String cc, String bcc, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
//            message.setFrom("support@nhaicare.com");
          //  message.setFrom("dibyajeet.das@mapmyindia.com");
            message.setFrom("dibyajeetdas1@gmail.com");

            // TO (multiple allowed, comma separated)
            message.setTo(to.split(","));

            // CC (optional)
            if (cc != null && !cc.trim().isEmpty()) {
                message.setCc(cc.split(","));
            }

            // BCC (optional)
            if (bcc != null && !bcc.trim().isEmpty()) {
                message.setBcc(bcc.split(","));
            }

            message.setSubject(subject);
            message.setText(text);

            mailSender.send(message);
          
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send email: " + e.getMessage();
        }
        return "Email sent successfully to: " + to;
    }
}
