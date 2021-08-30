package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.Necessity;
import br.com.yunikonshine.refugiobrasil.model.request.NecessityRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface NecessityMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    Necessity fromRequest(NecessityRequest necessityRequest);

}
