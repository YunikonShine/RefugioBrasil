package br.com.yunikonshine.refugiobrasil.client;

import br.com.yunikonshine.refugiobrasil.model.response.ViaCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${feign.url.viacep}", name = "viaCepClient")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    ViaCepResponse getAddress(@PathVariable String cep);

}
