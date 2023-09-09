package com.academia.academiaalunos.repository;

import com.academia.academiaalunos.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNome(String nome);
}
