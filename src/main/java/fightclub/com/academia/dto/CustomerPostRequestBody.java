package fightclub.com.academia.dto;

import fightclub.com.academia.entity.Address;
import fightclub.com.academia.utils.RegexUtils;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerPostRequestBody {

    @NotNull(message = "Nome inválido, por favor insira um nome válido.")
    @Schema(description = "This is the customer name.", example = "José", required = true)
    private String firstName;

    @NotNull(message = "Sobrenome inválido, por favor insira um sobrenome válido.")
    @Schema(description = "This is the customer last name.", example = "dos Santos", required = true)
    private String lastName;

    @NotNull(message = "Cpf inválido.")
    @CPF(message = "Cpf inválido, por favor Insira um cpf válido.")
    @Pattern(regexp = RegexUtils.CPF_REGEX)
    @Schema(description = "This is the customer individual registration", example = "43571497031", required = true)
    private String cpf;

    @NotNull(message = "Idade inválida, por favor insira uma idade válida.")
    @Schema(description = "This is the customer age", example = "22", required = true)
    private Integer age;

    @NotNull(message = "Telefone inválido, por favor insira uma idade válida")
    @Schema(description = "This is the customer cellphone.", example = "5521965904839", required = true)
    @Pattern(regexp = RegexUtils.CELLPHONE_REGEX_BRL)
    private String cellphone;

    @NotNull(message = "Endereço inválido, por favor preencha corretamente.")
    @Schema(description = "This is the customer Address.", required = true)
    private Address address;
}