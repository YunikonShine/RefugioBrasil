package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.FormationNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongFormationException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongPhoneException;
import br.com.yunikonshine.refugiobrasil.exception.PhoneNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.mapper.FormationMapper;
import br.com.yunikonshine.refugiobrasil.model.request.FormationRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.PhoneRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.service.FormationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class FormationController {

    private final FormationService formationService;

    private final FormationMapper formationMapper;

    @PostMapping
    public ResponseEntity saveFormation(@RequestBody @Valid FormationRefugeeRequest formationRefugeeRequest) {
        formationService.save(formationMapper.fromRequest(formationRefugeeRequest));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{formationId}/{refugeeId}")
    public ResponseEntity updateFormation(@PathVariable String formationId, @PathVariable String refugeeId, @RequestBody FormationRefugeeRequest formationRefugeeRequest) throws FormationNotFoundException, NonBelongFormationException {
        formationService.update(formationMapper.fromRequest(formationRefugeeRequest, formationId, refugeeId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{formationId}")
    public ResponseEntity deleteFormation(@PathVariable String formationId) throws FormationNotFoundException {
        formationService.delete(formationId);
        return ResponseEntity.noContent().build();
    }

}
