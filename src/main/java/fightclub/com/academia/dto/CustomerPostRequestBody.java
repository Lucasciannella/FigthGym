package fightclub.com.academia.dto;

import fightclub.com.academia.entity.Address;
import fightclub.com.academia.utils.RegexUtils;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPostRequestBody {
    @NotEmpty
    @NotNull
    private String firstName;

    @NotEmpty
    @NotNull
    private String lastName;

    @NotEmpty
    @NotNull
    @CPF(message = "Por favor insira um cpf válido")
    @Pattern(regexp = RegexUtils.CPF_REGEX)
    private String cpf;

    @NotNull
    private Long age;

    @NotEmpty
    @NotNull
    private String cellphone;

    @NotNull
    private Address address;
}