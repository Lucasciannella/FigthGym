package fightclub.com.academia.services;

import fightclub.com.academia.entity.AccountStatus;
import fightclub.com.academia.entity.AccountType;
import fightclub.com.academia.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    
    public List<Payment> generatePaymentForCadastredCustomer() {
        var today = LocalDate.now();
        var dueDate = today.plusDays(30);
        Payment paymento = Payment.builder()
                .paymentOrder(new BigDecimal("80.00"))
                .accessionDate(today)
                .accountStatus(AccountStatus.PENDING_PAYMENT)
                .accountType(AccountType.BASIC)
                .dueDate(dueDate)
                .build();

        var payments = new ArrayList<Payment>();
        payments.add(paymento);

        return payments;
    }


}
