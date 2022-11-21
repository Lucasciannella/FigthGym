package fightclub.com.academia.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(schema = "CONECT", name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER_TB")
public class Customer {
    @Id
    @Schema(hidden = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long id;

    @Column(name = "FORENAME", length = 50, nullable = false)
    @Schema(description = "This is the customer name.", example = "José", required = true)
    private String firstName;

    @Column(name = "SURNAME", length = 50, nullable = false)
    @Schema(description = "This is the customer last name.", example = "dos Santos", required = true)
    private String lastName;

    @Column(name = "CUSTOMER_CPF", length = 11, unique = true)
    @Schema(description = "This is the customer individual registration", example = "43571497031", required = true)
    private String cpf;

    @Column(name = "CUSTOMER_AGE", length = 3, nullable = false)
    @Schema(description = "This is the customer age", example = "22", required = true)
    private Integer age;

    @Column(name = "CUSTOMER_CELLPHONE", nullable = false)
    @Schema(description = "This is the customer cellphone.", example = "5521985704798", required = true)
    private String cellphone;

    @OneToOne(cascade = CascadeType.ALL)
    @Schema(description = "This is the customer Address.", required = true)
    private Address address;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @Column(name = "PAYMENTS_ID")
    private List<Payment> payments;
}