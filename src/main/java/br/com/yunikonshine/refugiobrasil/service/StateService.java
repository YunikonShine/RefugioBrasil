package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.model.mapper.StateMapper;
import br.com.yunikonshine.refugiobrasil.model.response.StateResponse;
import br.com.yunikonshine.refugiobrasil.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StateService {

    private final StateMapper stateMapper;

    private final StateRepository stateRepository;

    public List<StateResponse> findAll() {
        return stateRepository.findAll()
                .stream()
                .map(stateMapper::toResponse)
                .collect(Collectors.toList());
    }

}
