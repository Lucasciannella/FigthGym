package fightclub.com.academia.repositorio;

import fightclub.com.academia.entidades.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Long, Aluno> {
    String fyndByNamme(String nome);
}
