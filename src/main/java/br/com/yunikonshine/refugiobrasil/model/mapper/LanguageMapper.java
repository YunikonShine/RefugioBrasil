package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Language;
import br.com.yunikonshine.refugiobrasil.model.request.LanguageRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.LanguageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface LanguageMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Language fromRequest(LanguageRequest languageRequest);

    Language fromRequest(LanguageRequest languageRequest, String id, String refugeeId);

    Language fromRequest(LanguageRefugeeRequest languageRequest);

}
