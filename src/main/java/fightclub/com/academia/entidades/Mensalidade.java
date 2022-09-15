package fightclub.com.academia.entidades;


import fightclub.com.academia.utils.StatusMensalidade;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@SequenceGenerator(name = "mensalidade_seq", sequenceName = "mensalidade_seq", initialValue = 1, allocationSize = 1)
public class Mensalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mensalidade_seq")
    private Long id;
    @Column(name = "data_de_vencimento")
    private LocalDate dataDeVencimento;
    @Column(name = "valor_mensalidade")
    private Double valorMensalidade;
    @Column(name = "status_mensalidade")
    private StatusMensalidade statusMensalidade;
    @ManyToOne
    private Aluno aluno;
}