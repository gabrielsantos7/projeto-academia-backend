package com.academia.academiaalunos.requests;

import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.domain.Endereco;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

@Data
public class AlunoPutRequestBody {
    @NotNull
    private long id;
    
    @NotBlank
    private String nome;

    @NotBlank
    @Pattern(regexp = "(\\(\\d{2}\\))?\\s?\\d{4,5}-\\d{4}", message = "Formato de telefone inválido")
    private String telefone;

    @NotNull
    private LocalDate dataNascimento;

    @NotNull
    private Endereco endereco;

    private List<Avaliacao> avaliacoes;

}


