package fightclub.com.academia.servico;

import fightclub.com.academia.repositorio.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;
}