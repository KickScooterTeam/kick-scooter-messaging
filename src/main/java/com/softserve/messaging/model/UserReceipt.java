package com.softserve.messaging.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@ToString(includeFieldNames = true, exclude = "email")
public class UserReceipt {
    private UUID userId;
    private BigDecimal tripCost;
    private String currency;
    private LocalDateTime paymentDate;

    /*  these fields are temporary(payment doesn't store userEmail), must be changed with new functionality in future,
    i.e rest endpoint in identity service*/
    private String email;
    private String firstName;
}
