package com.academia.academiaalunos.domain;

import javax.persistence.*;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "alunos")
 @JsonIdentityInfo(
     generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
 )
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno")
    private Long id;

    private String nome;

    private String telefone;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    @JsonManagedReference // Esta anotação controla a serialização para evitar recursão infinita
    private List<Avaliacao> avaliacoes;    

}
