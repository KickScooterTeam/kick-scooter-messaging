package com.softserve.messaging.dto;

import lombok.Data;

@Data
public class UserValidation {
    private String email;
    private String verificationPath;
}
