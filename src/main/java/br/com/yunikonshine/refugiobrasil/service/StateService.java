package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.model.domain.State;
import br.com.yunikonshine.refugiobrasil.repository.StateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StateService {

    private final StateRepository stateRepository;

    public List<State> findAll() {
        return stateRepository.findAll();
    }

}
