package fightclub.com.academia.dto;

import fightclub.com.academia.entity.Address;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPostRequestBody {

    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    private String firstName;

    @NotBlank(message = "Campo de sobrenome não pode ser nulo ou vazio")
    private String lastName;

    @NotBlank(message = "Campo cpf não pode ser nulo ou vazio")
    @CPF(message = "Cpf inválido")
    private String cpf;

    @NotBlank
    private LocalDate birthDate;

    @NotBlank
    private String cellphone;

    @NotNull
    private Address address;
}