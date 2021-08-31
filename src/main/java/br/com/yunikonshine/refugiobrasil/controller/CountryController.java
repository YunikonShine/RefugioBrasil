package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.model.domain.Country;
import br.com.yunikonshine.refugiobrasil.model.mapper.CountryMapper;
import br.com.yunikonshine.refugiobrasil.model.response.CountryResponse;
import br.com.yunikonshine.refugiobrasil.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    private final CountryMapper countryMapper;

    @GetMapping
    public List<CountryResponse> getCountries() {
        List<Country> countries = countryService.findAll();
        return countries.stream().map(countryMapper::toResponse).collect(Collectors.toList());
    }

}
