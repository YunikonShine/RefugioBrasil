package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.response.CityResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    CityResponse toResponse(City city);

}
