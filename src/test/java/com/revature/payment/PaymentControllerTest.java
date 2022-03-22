package com.revature.payment;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentControllerTest {

    @Autowired
    PaymentController paymentController;

    @Test
    public void testGetAllPayments() {
        List<Payment> payments = paymentController.getAllPayments();
        for (Payment payment : payments) {
            assert payment.getPaymentTxnId() != null;
            assert payment.getFailureReason() != null;
            assert payment.getPaymentType() != null;
            assert payment.getPaymentTxnSuccess() != null;
        }
    }
}
