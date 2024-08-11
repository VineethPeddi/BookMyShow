package org.example.bookmyshow.dtos;

import lombok.Getter;

@Getter
public class MakePaymentRequestDTO {
    private Long  paymentProviderId;
    private int amount;
    private Long paymentModeId;
}
