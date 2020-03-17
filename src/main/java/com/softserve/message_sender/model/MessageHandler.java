package com.softserve.message_sender.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class MessageHandler {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private UUID userUUID;
    private String messageBody;
    private ZonedDateTime zonedDateTime;

    @Transient
    private String firstName;
    @Transient
    private String lastName;
    @Transient
    private String mail;
    @Transient
    private double cost;
    @Transient
    private String token;

    public static final String TITLE = "Electronic receipt";

    @Override
    public String toString() {
        return String.format("Hello, %s. Thanks for a ride. We hope you've enjoyed it.%nTotal cost: %.2f $", getFirstName(), getCost());
    }

    //TODO util class for static strings?
}
