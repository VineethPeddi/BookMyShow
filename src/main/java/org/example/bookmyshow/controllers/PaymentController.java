package org.example.bookmyshow.controllers;

import org.example.bookmyshow.dtos.MakePaymentRequestDTO;
import org.example.bookmyshow.dtos.MakePaymentResponseDTO;
import org.example.bookmyshow.dtos.ResponseStatus;
import org.example.bookmyshow.models.Payment;
import org.example.bookmyshow.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    public MakePaymentResponseDTO makePayment(MakePaymentRequestDTO requestDTO){
        MakePaymentResponseDTO response=new MakePaymentResponseDTO();
        try{
            Payment payment=paymentService.makePayment(requestDTO.getPaymentProviderId(),requestDTO.getAmount(),requestDTO.getPaymentModeId());
            response.setRefNo(payment.getRefNo());
            response.setStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            response.setStatus(ResponseStatus.FAILURE);
            response.setFailureMessage(e.getMessage());
        }
        return response;
    }

}
