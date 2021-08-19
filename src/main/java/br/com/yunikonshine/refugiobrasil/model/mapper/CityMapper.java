package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.response.CityResponse;
import br.com.yunikonshine.refugiobrasil.model.response.CityStateResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityStateResponse toCityStateResponse(City city);

    CityResponse toResponse(City city);

}
