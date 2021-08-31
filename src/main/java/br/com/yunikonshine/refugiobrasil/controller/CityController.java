package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.model.domain.City;
import br.com.yunikonshine.refugiobrasil.model.mapper.CityMapper;
import br.com.yunikonshine.refugiobrasil.model.request.StateRequest;
import br.com.yunikonshine.refugiobrasil.model.response.CityResponse;
import br.com.yunikonshine.refugiobrasil.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    private final CityMapper cityMapper;

    @GetMapping("/{state}")
    public List<CityResponse> getCitiesByState(@PathVariable @Valid StateRequest state) {
        List<City> cities = cityService.findByState(Long.parseLong(state.getId()));
        return cities.stream().map(cityMapper::toResponse).collect(Collectors.toList());
    }

}
