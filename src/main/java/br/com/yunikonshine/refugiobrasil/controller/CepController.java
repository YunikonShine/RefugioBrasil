package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.request.CepRequest;
import br.com.yunikonshine.refugiobrasil.model.response.CepResponse;
import br.com.yunikonshine.refugiobrasil.service.CepService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public CepResponse getByCep(@PathVariable @Valid CepRequest cep) throws CepNotFoundException {
        return cepService.getDataByCep(cep.getCep());
    }

}
