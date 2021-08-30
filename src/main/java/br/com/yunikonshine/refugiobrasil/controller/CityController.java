package br.com.yunikonshine.refugiobrasil.controller;

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

@Validated
@RestController
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/{state}")
    public List<CityResponse> getCitiesByState(@PathVariable @Valid StateRequest state) {
        return cityService.findByState(Long.parseLong(state.getId()));
    }

}
