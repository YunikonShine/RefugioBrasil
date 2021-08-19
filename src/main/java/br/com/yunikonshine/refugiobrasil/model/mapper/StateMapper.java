package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.State;
import br.com.yunikonshine.refugiobrasil.model.response.StateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StateMapper {

    StateResponse toResponse(State state);

}
