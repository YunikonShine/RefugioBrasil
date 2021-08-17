package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.model.mapper.CountryMapper;
import br.com.yunikonshine.refugiobrasil.model.response.CountryResponse;
import br.com.yunikonshine.refugiobrasil.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryMapper countryMapper;

    private final CountryRepository countryRepository;

    public List<CountryResponse> findAll() {
        return countryRepository.findAll()
                .stream()
                .map(countryMapper::toResponse)
                .collect(Collectors.toList());
    }

}
