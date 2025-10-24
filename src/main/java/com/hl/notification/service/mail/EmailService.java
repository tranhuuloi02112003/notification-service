package com.hl.notification.service.mail;

import com.hl.notification.dto.SendEmailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailFrom;

    public void sendMail(SendEmailRequest sendEmailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailFrom);
        message.setTo(sendEmailRequest.getTo());
        message.setSubject(sendEmailRequest.getSubject());
        message.setText(sendEmailRequest.getText());
        mailSender.send(message);
    }
}


