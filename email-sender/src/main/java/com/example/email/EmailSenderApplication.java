package com.example.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailSenderApplication implements CommandLineRunner {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(EmailSenderApplication.class, args);
    }

    @Override
    public void run(String... args) {
        emailService.sendEmail(
            "dibyajeet.das@mapmyindia.com",       // To
            "vivek.k@mapmyindia.com",            // CC (can be comma separated)
            "bccperson@example.com",            // BCC (can be comma separated)
            "Test Email from Spring Boot",      // Subject
            "Hello, this is a test email sent via Gmail SMTP using Spring Boot!" // Body
        );
    }
}
