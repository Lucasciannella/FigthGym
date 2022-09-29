package fightclub.com.academia.dto;

import fightclub.com.academia.entity.Address;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPostRequestBody {
    @NotEmpty
    @NotNull
    @NotBlank(message = "Campo nome não pode ser nulo ou vazio")
    private String firstName;

    @NotEmpty
    @NotNull
    @NotBlank(message = "Campo de sobrenome não pode ser nulo ou vazio")
    private String lastName;

    @NotEmpty
    @NotNull
    @NotBlank(message = "Campo cpf não pode ser nulo ou vazio")
    @CPF(message = "Cpf inválido")
    private String cpf;

    @NotEmpty
    @NotNull
    @NotBlank
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthDate;

    @NotEmpty
    @NotNull
    @NotBlank
    private String cellphone;

    @NotEmpty
    @NotNull
    @NotNull
    private Address address;
}