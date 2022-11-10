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

    @NotNull
    @Schema(description = "This is the customer name", example = "José", required = true)
    private String firstName;

    @NotNull
    @Schema(description = "this is the customer last name", example = "dos Santos", required = true)
    private String lastName;

    @NotNull
    @CPF(message = "Por favor insira um cpf válido")
    @Pattern(regexp = RegexUtils.CPF_REGEX)
    @Schema(description = "This is the customer individual registration", example = "43571497031", required = true)
    private String cpf;

    @NotNull
    @Schema(description = "This is the customer age", example = "22", required = true)
    private Integer age;

    @NotNull
    @Schema(description = "This is the customer cellphone", example = "5521965904839", required = true)
    private String cellphone;

    @NotNull
    @Schema(description = "This is the customer Address", required = true)
    private Address address;
}