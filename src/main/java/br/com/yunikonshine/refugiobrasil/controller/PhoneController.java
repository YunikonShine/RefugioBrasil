package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.LanguageNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongLanguageException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongPhoneException;
import br.com.yunikonshine.refugiobrasil.exception.PhoneNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.mapper.PhoneMapper;
import br.com.yunikonshine.refugiobrasil.model.request.LanguageRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.PhoneRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.service.PhoneService;
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
public class PhoneController {

    private final PhoneService phoneService;

    private final PhoneMapper phoneMapper;

    @PostMapping
    public ResponseEntity savePhone(@RequestBody @Valid PhoneRefugeeRequest phoneRefugeeRequest) {
        phoneService.save(phoneMapper.fromRequest(phoneRefugeeRequest));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{phoneId}/{refugeeId}")
    public ResponseEntity updatePhone(@PathVariable String phoneId, @PathVariable String refugeeId, @RequestBody PhoneRefugeeRequest phoneRefugeeRequest) throws PhoneNotFoundException, NonBelongPhoneException {
        phoneService.update(phoneMapper.fromRequest(phoneRefugeeRequest, phoneId, refugeeId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{phoneId}")
    public ResponseEntity deletePhone(@PathVariable String phoneId) throws PhoneNotFoundException {
        phoneService.delete(phoneId);
        return ResponseEntity.noContent().build();
    }

}
