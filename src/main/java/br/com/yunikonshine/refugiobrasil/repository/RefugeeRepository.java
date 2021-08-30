package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RefugeeRepository {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void save(Refugee refugee) {
        System.out.println(objectMapper.writeValueAsString(refugee));
    }

}
