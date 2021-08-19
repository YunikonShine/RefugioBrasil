package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface DocumentMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Document toEntity(DocumentRequest documentRequest);

}
