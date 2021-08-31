package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.model.domain.Country;
import br.com.yunikonshine.refugiobrasil.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

}
