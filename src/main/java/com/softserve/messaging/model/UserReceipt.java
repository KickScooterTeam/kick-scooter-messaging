package com.softserve.messaging.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
@ToString(exclude = "email")
public class UserReceipt {
    private UUID userId;
    private BigDecimal tripCost;
    private String currency;
    private Instant paymentDate;

    /*  these fields are temporary(payment doesn't store userEmail), must be changed with new functionality in future,
    i.e get them from the identity service*/
    private String email;
    private String firstName;
}
