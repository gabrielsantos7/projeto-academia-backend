package com.academia.academiaalunos.requests;

import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.domain.Endereco;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;


@Data
public class AlunoPostRequestBody {
    @NotBlank
    private String nome;

    @NotBlank
    private String telefone;

    @NotNull
    private LocalDate dataNascimento;

    private List<Avaliacao> avaliacoes;

    @NotNull
    private Endereco endereco;

}

