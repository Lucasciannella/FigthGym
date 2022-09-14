package fightclub.com.academia.entidades;

import javax.persistence.*;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String primeiroNome;

    @Column(nullable = false, length = 100)
    private String segundoNome;

    @Column(nullable = false, length = 11, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String anoDeNascimento;

    @Column(nullable = false)
    private String telefone;

//    @OneToOne
//    private Endereco endereco;
//
//    @OneToMany
//    private Mensalidade mensalidade;
}