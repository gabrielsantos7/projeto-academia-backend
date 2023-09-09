package com.academia.academiaalunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapping;

import com.academia.academiaalunos.domain.Aluno;
import com.academia.academiaalunos.requests.AlunoPostRequestBody;
import com.academia.academiaalunos.requests.AlunoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AlunoMapper {
   public static final AlunoMapper INSTANCE  = Mappers.getMapper(AlunoMapper.class);

   @Mapping(target = "id", ignore = true)
   public abstract Aluno toAluno(AlunoPostRequestBody alunoPostRequestBody);

   public abstract Aluno toAluno(AlunoPutRequestBody alunoPutRequestBody);
}
