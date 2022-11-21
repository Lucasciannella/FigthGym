package fightclub.com.academia.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fightclub.com.academia.domain.enums.AccountStatus;
import fightclub.com.academia.domain.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "PAYMENT_TB")
@SequenceGenerator(name = "payment_seq", sequenceName = "payment_seq", initialValue = 1, allocationSize = 1)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq")
    private Long id;

    @Column(name = "PAYMENT_ORDER", nullable = false)
    private BigDecimal paymentOrder;

    @Column(name = "DUE_DATE", nullable = false)
    private LocalDate dueDate;

    @Column(name = "ACCESSION_DATE", nullable = false)
    private LocalDate accessionDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNTE_TYPE", nullable = false)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "ACCOUNT_STATUS", nullable = false)
    private AccountStatus accountStatus;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}