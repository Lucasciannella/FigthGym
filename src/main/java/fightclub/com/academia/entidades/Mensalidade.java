package fightclub.com.academia.entidades;


import fightclub.com.academia.utils.StatusMensalidade;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Mensalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataDePagamento;
    private LocalDate dataDeVencimento;
    private Double valorMensalidade;
    private StatusMensalidade statusMensalidade;
}