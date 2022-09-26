package fightclub.com.academia.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String cellphone;

    @Column(nullable = false)
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Payment> payment;
}