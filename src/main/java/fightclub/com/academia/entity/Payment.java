package fightclub.com.academia.entity;


import fightclub.com.academia.utils.PaymentStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", initialValue = 1, allocationSize = 1)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private Long id;
    private LocalDate dueDate;
    private Double paymentPrice;
    private PaymentStatus paymentStatus;
    @ManyToOne
    private Customer customer;
}