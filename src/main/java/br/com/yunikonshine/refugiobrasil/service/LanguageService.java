package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.LanguageNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongLanguageException;
import br.com.yunikonshine.refugiobrasil.model.domain.Language;
import br.com.yunikonshine.refugiobrasil.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {

    private final LanguageRepository languageRepository;

    public void update(Language language) throws LanguageNotFoundException, NonBelongLanguageException {
        languageRepository.validBelongProfessionFromRefugee(language.getId(), language.getRefugeeId());
        languageRepository.update(language);
    }

    public void delete(String languageId) throws LanguageNotFoundException {
        languageRepository.delete(languageId);
    }

    public void save(Language language) {
        languageRepository.save(language);
    }
}
