package com.academia.academiaalunos.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.academia.academiaalunos.domain.Avaliacao;
import com.academia.academiaalunos.requests.AvaliacaoPostRequestBody;
import com.academia.academiaalunos.requests.AvaliacaoPutRequestBody;

@Mapper(componentModel = "spring")
public abstract class AvaliacaoMapper {
   public static final AvaliacaoMapper INSTANCE  = Mappers.getMapper(AvaliacaoMapper.class);

   @Mapping(target = "id", ignore = true)
   public abstract Avaliacao toAvaliacao(AvaliacaoPostRequestBody avaliacaoPostRequestBody);

   public abstract Avaliacao toAvaliacao(AvaliacaoPutRequestBody avaliacaoPutRequestBody);
}