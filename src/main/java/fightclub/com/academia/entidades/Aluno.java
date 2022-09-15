package fightclub.com.academia.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "aluno_seq", sequenceName = "aluno_seq", initialValue = 1, allocationSize = 1)
@Getter
@Setter
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aluno_seq")
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;
    @Column(name = "ano_de_nascimento")
    private String anoDeNascimento;
    private String telefone;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private List<Mensalidade> mensalidade;
}