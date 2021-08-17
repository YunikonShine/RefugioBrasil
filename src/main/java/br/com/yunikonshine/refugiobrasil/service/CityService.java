package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public City findByName(String name) throws CepNotFoundException {
        return cityRepository.findByName(name).orElseThrow(() -> new CepNotFoundException());
    }

}
