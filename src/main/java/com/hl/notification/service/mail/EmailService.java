package com.hl.notification.service.mail;

import com.hl.notification.dto.SendEmailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String mailFrom;

    @Value("${spring.mail.activation.base-url}")
    private String baseUrl;

    @SneakyThrows
    public void sendMail(SendEmailRequest sendEmailRequest){
        String activationLink = baseUrl + "?token=" + sendEmailRequest.getToken();
        Context context = new Context();
        context.setVariable("fullName", sendEmailRequest.getFullName());
        context.setVariable("activationLink", activationLink);

        String html = templateEngine.process("activation", context);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        helper.setFrom(mailFrom);
        helper.setTo(sendEmailRequest.getTo());
        helper.setSubject("Verify your email address");
        helper.setText(html, true);

        mailSender.send(mimeMessage);
    }
}


