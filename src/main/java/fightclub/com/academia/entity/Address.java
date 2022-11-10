package fightclub.com.academia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "adress_seq", sequenceName = "adress_seq", initialValue = 1, allocationSize = 1)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adress_seq")
    @Schema(hidden = true)
    private Long id;

    @Schema(description = "This is the customer federative unit", example = "RJ", required = true)
    private String uf;

    @Schema(description = "This is the customer city", example = "Rio De Janeiro", required = true)
    private String cidade;

    @Schema(description = "This is the customer district", example = "Barra da Tijuca", required = true)
    private String bairro;

    @Schema(description = "This is the customer road", example = "Avenida das américas", required = true)
    private String endereco;

    @Schema(description = "This is the customer complement", example = "Fundos", required = true)
    private String complemento;
}