package fightclub.com.academia.entidades;

import javax.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String bairro;
    @Column(nullable = false, length = 100)
    private String nomeDaRua;
    @Column(length = 100)
    private Integer numero;
}