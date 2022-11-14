package fightclub.com.academia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", initialValue = 1, allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @Schema(hidden = true)
    private Long id;

    @Column(nullable = false)
    @Schema(description = "This is the customer name.", example = "José", required = true)
    private String firstName;

    @Column(nullable = false)
    @Schema(description = "This is the customer last name.", example = "dos Santos", required = true)
    private String lastName;

    @Column(unique = true)
    @Schema(description = "This is the customer individual registration", example = "43571497031", required = true)
    private String cpf;

    @Column(nullable = false)
    @Schema(description = "This is the customer age", example = "22", required = true)
    private Integer age;

    @Column(nullable = false)
    @Schema(description = "This is the customer cellphone.", example = "5521985704798", required = true)
    private String cellphone;

    @OneToOne(cascade = CascadeType.ALL)
    @Schema(description = "This is the customer Address.", required = true)
    private Address address;
}