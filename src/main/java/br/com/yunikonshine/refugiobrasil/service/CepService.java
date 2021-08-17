package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.client.ViaCepClient;
import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.mapper.CepMapper;
import br.com.yunikonshine.refugiobrasil.model.response.CepResponse;
import br.com.yunikonshine.refugiobrasil.model.response.client.ViaCepResponse;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CepService {

    private final CepMapper cepMapper;

    private final ViaCepClient viaCepClient;

    private final CityService cityService;

    public CepResponse getDataByCep(String cep) throws CepNotFoundException {
        ViaCepResponse viaCepResponse = viaCepClient.getAddress(cep);
        if(Strings.isNullOrEmpty(viaCepResponse.getCep())) {
            throw new CepNotFoundException();
        }
        City city = cityService.findByName(viaCepResponse.getCity());
        return cepMapper.toResponse(viaCepResponse, city);
    }

}
