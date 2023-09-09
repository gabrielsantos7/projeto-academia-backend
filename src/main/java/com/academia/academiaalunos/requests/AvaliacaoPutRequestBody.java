package com.academia.academiaalunos.requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.academia.academiaalunos.domain.Aluno;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AvaliacaoPutRequestBody {
   @NotNull
   private Long id;
   
   @NotNull
    private LocalDate data;
    
    @NotNull
    private Double peso;
    
    @NotNull
    private Double altura;
    
    @NotEmpty
    private List<Double> medidas;
    
    @NotNull
    private Double porcentagemGordura;
    
    // Observações não é um obrigatório
    private String observacoes;
    
    @NotNull
    private Aluno aluno;

}
