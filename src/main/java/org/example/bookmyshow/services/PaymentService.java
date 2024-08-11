package org.example.bookmyshow.services;

import org.example.bookmyshow.models.Payment;
import org.example.bookmyshow.models.PaymentMode;
import org.example.bookmyshow.models.PaymentProvider;
import org.example.bookmyshow.models.PaymentStatus;
import org.example.bookmyshow.repositories.PaymentModeRepository;
import org.example.bookmyshow.repositories.PaymentProviderRepository;
import org.example.bookmyshow.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentProviderRepository paymentProviderRepository;
    @Autowired
    private PaymentModeRepository paymentModeRepository;
    public Payment makePayment(long paymentProviderId,int amount,long paymentModeId){
        Optional<PaymentProvider> optionalPaymentProvider=paymentProviderRepository.findById(paymentProviderId);
        if (optionalPaymentProvider.isEmpty())throw new RuntimeException("payment provider not found");
        Optional<PaymentMode> optionalPaymentMode=paymentModeRepository.findById(paymentModeId);
        if (optionalPaymentMode.isEmpty())throw new RuntimeException("Payment mode not found");

        // TODO: add adapter and libraries to integrate multiple payment gateways

        Payment payment=new Payment();
        payment.setRefNo(UUID.randomUUID()+"");
        payment.setPaymentMode(optionalPaymentMode.get());
        payment.setPaymentProvider(optionalPaymentProvider.get());
        payment.setAmount(amount);
        payment.setPaymentStatus(PaymentStatus.SUCCESS);
        payment.setTxnDate(new Date());
        return paymentRepository.save(payment);
    }
}
