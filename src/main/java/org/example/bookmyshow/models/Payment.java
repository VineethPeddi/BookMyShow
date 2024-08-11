package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    private String refNo;
    private PaymentProvider paymentProvider;
    private int amount;
    private Date txnDate;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
}
