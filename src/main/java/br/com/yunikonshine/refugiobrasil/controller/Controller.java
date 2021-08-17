package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.client.ViaCepClient;
import br.com.yunikonshine.refugiobrasil.model.response.ViaCepResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class Controller {

    private final ViaCepClient viaCepClient;

    @GetMapping("/{cep}")
    public ViaCepResponse getAddress(@PathVariable String cep) {
        log.info(cep);
        return viaCepClient.getAddress(cep);
    }

}
