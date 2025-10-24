package com.hl.notification.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendEmailRequest {
    private String to;
    private String subject;
    private String text;
}
