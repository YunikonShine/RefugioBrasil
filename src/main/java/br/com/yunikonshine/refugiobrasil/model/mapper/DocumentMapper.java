package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface DocumentMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Document toEntity(DocumentRequest documentRequest);

    @AfterMapping
    default void onlyDigits(@MappingTarget Document document) {
        document.setNumber(document.getNumber().replaceAll("[^a-zA-Z0-9]",""));
    }

}
