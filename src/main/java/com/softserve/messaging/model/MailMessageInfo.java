package com.softserve.messaging.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class MailMessageInfo {
    //todo change name to a more appropriate one for this entity

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    @Enumerated(EnumType.STRING)
    private EmailTarget emailTarget;
    private String fieldsSummary;
}
