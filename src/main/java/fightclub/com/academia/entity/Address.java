package fightclub.com.academia.entity;

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
    private Long id;
    private String uf;
    private String cidade;
    private String bairro;
    private String endereco;
    private String complemento;
}