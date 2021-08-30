package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.mapper.CityMapper;
import br.com.yunikonshine.refugiobrasil.model.response.CityResponse;
import br.com.yunikonshine.refugiobrasil.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CityService {

    private final CityMapper cityMapper;

    private final CityRepository cityRepository;

    public City findByName(String name) throws CepNotFoundException {
        return cityRepository.findByName(name);
    }

    public List<CityResponse> findByState(Long stateId) {
        return cityRepository.findByState(stateId).stream()
                .map(cityMapper::toResponse).collect(Collectors.toList());
    }

}
