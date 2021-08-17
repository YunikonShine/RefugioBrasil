package br.com.yunikonshine.refugiobrasil.model.mapper;

import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.response.CepResponse;
import br.com.yunikonshine.refugiobrasil.model.response.client.ViaCepResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface CepMapper {

    @Mapping(source = "city", target = "city", qualifiedByName = "cityMapper.toResponse")
    CepResponse toResponse(ViaCepResponse viaCepResponse, City city);

}
