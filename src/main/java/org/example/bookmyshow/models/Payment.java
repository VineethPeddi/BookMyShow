package org.example.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
    String refNo;
    PaymentProvider paymentProvider;
    int amount;
    Date txnDate;
    PaymentMode paymentMode;
    PaymentStatus paymentStatus;
}
