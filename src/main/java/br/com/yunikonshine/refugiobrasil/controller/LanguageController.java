package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.LanguageNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongLanguageException;
import br.com.yunikonshine.refugiobrasil.model.mapper.LanguageMapper;
import br.com.yunikonshine.refugiobrasil.model.request.LanguageRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.service.LanguageService;
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
public class LanguageController {

    private final LanguageService languageService;

    private final LanguageMapper languageMapper;

    @PostMapping
    public ResponseEntity saveLanguage(@RequestBody @Valid LanguageRefugeeRequest languageRefugeeRequest) {
        languageService.save(languageMapper.fromRequest(languageRefugeeRequest));
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{languageId}/{refugeeId}")
    public ResponseEntity updateLanguage(@PathVariable String languageId, @PathVariable String refugeeId, @RequestBody LanguageRefugeeRequest languageRefugeeRequest) throws LanguageNotFoundException, NonBelongLanguageException {
        languageService.update(languageMapper.fromRequest(languageRefugeeRequest, languageId, refugeeId));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{languageId}")
    public ResponseEntity deleteLanguage(@PathVariable String languageId) throws LanguageNotFoundException {
        languageService.delete(languageId);
        return ResponseEntity.noContent().build();
    }

}
