package com.academia.academiaalunos.service;

import org.springframework.stereotype.Service;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.exception.BadRequestException;
import com.academia.academiaalunos.repository.AlunoRepository;
import com.academia.academiaalunos.repository.AvaliacaoRepository;
import com.academia.academiaalunos.requests.AvaliacaoPostRequestBody;
import com.academia.academiaalunos.requests.AvaliacaoPutRequestBody;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {
    private final AvaliacaoRepository avaliacaoRepository;
    private final AlunoRepository alunoRepository;

    public List<Avaliacao> listAll() {
        return avaliacaoRepository.findAll();
    }

    public Avaliacao findByIdOrThrowBadRequestException(Long id) {
        return avaliacaoRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Avaliacao not found"));
    }

    public List<Avaliacao> findByAluno(Long idAluno) {
        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new BadRequestException("Aluno not found"));
        return avaliacaoRepository.findByAluno(aluno);
    }
    

    @Transactional
    public Avaliacao save(AvaliacaoPostRequestBody avaliacaoPostRequestBody) {
        Long alunoId = avaliacaoPostRequestBody.getAluno().getId();
        Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new BadRequestException("Aluno not found"));
        
            return avaliacaoRepository.save(
                Avaliacao.builder()
                .data(avaliacaoPostRequestBody.getData())
                .peso(avaliacaoPostRequestBody.getPeso())
                .altura(avaliacaoPostRequestBody.getAltura())
                .medidas(avaliacaoPostRequestBody.getMedidas())
                .porcentagemGordura(avaliacaoPostRequestBody.getPorcentagemGordura())
                .observacoes(avaliacaoPostRequestBody.getObservacoes())
                .aluno(aluno)
                .build()
            );
    }

    @Transactional
    public void replace(AvaliacaoPutRequestBody avaliacaoPutRequestBody) {
        Avaliacao savedAvaliacao = findByIdOrThrowBadRequestException(avaliacaoPutRequestBody.getId());
        Avaliacao avaliacao = Avaliacao.builder()
            .id(savedAvaliacao.getId())
            .data(avaliacaoPutRequestBody.getData())
            .peso(avaliacaoPutRequestBody.getPeso())
            .altura(avaliacaoPutRequestBody.getAltura())
            .medidas(avaliacaoPutRequestBody.getMedidas())
            .porcentagemGordura(avaliacaoPutRequestBody.getPorcentagemGordura())
            .observacoes(avaliacaoPutRequestBody.getObservacoes())
            .aluno(avaliacaoPutRequestBody.getAluno())
            .build();
        avaliacao.setId(savedAvaliacao.getId());
        avaliacaoRepository.save(avaliacao);
    }    

    @Transactional
    public void delete(Long id) {
        avaliacaoRepository.deleteById(id);
    }
}

