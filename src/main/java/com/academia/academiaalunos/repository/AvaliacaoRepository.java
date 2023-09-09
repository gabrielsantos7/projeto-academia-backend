package com.academia.academiaalunos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.domain.Aluno;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByAluno(Aluno aluno);
}
