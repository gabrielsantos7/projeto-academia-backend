package com.academia.academiaalunos.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "avaliacoes")
 @JsonIdentityInfo(
     generator = ObjectIdGenerators.PropertyGenerator.class,
     property = "id")
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    @JsonBackReference // Esta anotação controla a serialização para evitar recursão infinita
    private Aluno aluno;

    @Column(name = "data_avaliacao")
    private LocalDate data;

    private double peso;

    private double altura;

    @ElementCollection
    @CollectionTable(name = "medidas", joinColumns = @JoinColumn(name = "idAvaliacao"))
    @Column(name = "valor")
    private List<Double> medidas;

    @Column(name = "porcentagem_gordura")
    private double porcentagemGordura;

    private String observacoes;
}
