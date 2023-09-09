package com.academia.academiaalunos.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.exception.BadRequestException;
import com.academia.academiaalunos.mapper.AlunoMapper;
import com.academia.academiaalunos.repository.AlunoRepository;
import com.academia.academiaalunos.requests.AlunoPostRequestBody;
import com.academia.academiaalunos.requests.AlunoPutRequestBody;

import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public List<Aluno> listAll() {
        return alunoRepository.findAll();
    }

    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }
    
    public Aluno findByIdOrThrowBadRequestException(long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Aluno not found"));
    }
    
    @Transactional
    public Aluno save(AlunoPostRequestBody alunoPostRequestBody) {
        return alunoRepository.save(AlunoMapper.INSTANCE.toAluno(alunoPostRequestBody));
    }

    @Transactional
    public void replace(AlunoPutRequestBody alunoPutRequestBody) {
        Aluno savedAluno = findByIdOrThrowBadRequestException(alunoPutRequestBody.getId());
        Aluno aluno = AlunoMapper.INSTANCE.toAluno(alunoPutRequestBody);
        aluno.setId(savedAluno.getId());
        alunoRepository.save(aluno);
    }
    
    @Transactional
    public void delete(long id) {
        alunoRepository.delete(findByIdOrThrowBadRequestException(id));
    }
    
}
