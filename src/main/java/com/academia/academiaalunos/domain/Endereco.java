package com.academia.academiaalunos.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Builder
@Entity
@Table(name = "enderecos")
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id"
)
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;
    
    private String rua;

    private String numero;

    private String bairro;

    private String cidade;

    private String estado;

    private String cep;
    
    @OneToOne(mappedBy = "endereco")
    private Aluno aluno;
}
