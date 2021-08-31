package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.NonBelongProfessionException;
import br.com.yunikonshine.refugiobrasil.exception.ProfessionNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.mapper.ProfessionMapper;
import br.com.yunikonshine.refugiobrasil.model.request.ProfessionRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.service.ProfessionService;
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
@RequestMapping("/profession")
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService professionService;

    private final ProfessionMapper professionMapper;

    @PostMapping
    public ResponseEntity saveProfession(@RequestBody @Valid ProfessionRefugeeRequest professionRequest) {
        professionService.save(professionMapper.fromRequest(professionRequest));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{professionId}/{refugeeId}")
    public ResponseEntity updateProfession(@PathVariable String professionId, @PathVariable String refugeeId, @RequestBody ProfessionRefugeeRequest professionRequest) throws ProfessionNotFoundException, NonBelongProfessionException {
        professionService.update(professionMapper.fromRequest(professionRequest, professionId, refugeeId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{professionId}")
    public ResponseEntity deleteProfession(@PathVariable String professionId) throws ProfessionNotFoundException {
        professionService.delete(professionId);
        return ResponseEntity.noContent().build();
    }

}
