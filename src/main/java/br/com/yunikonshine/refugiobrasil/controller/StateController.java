package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.model.domain.State;
import br.com.yunikonshine.refugiobrasil.model.mapper.StateMapper;
import br.com.yunikonshine.refugiobrasil.model.response.StateResponse;
import br.com.yunikonshine.refugiobrasil.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/state")
@RequiredArgsConstructor
public class StateController {

    private final StateMapper stateMapper;

    private final StateService stateService;

    @GetMapping
    public List<StateResponse> getStates() {
        List<State> states = stateService.findAll();
        return states.stream().map(stateMapper::toResponse).collect(Collectors.toList());
    }

}
