package com.hl.notification.controller;

import com.hl.notification.dto.SendEmailRequest;
import com.hl.notification.service.mail.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emails")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void send(@RequestBody SendEmailRequest sendEmailRequest){
        emailService.sendMail(sendEmailRequest);
    }
}

