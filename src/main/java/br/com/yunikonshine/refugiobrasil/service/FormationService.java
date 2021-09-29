package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.FormationNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.LanguageNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongFormationException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongLanguageException;
import br.com.yunikonshine.refugiobrasil.model.domain.Formation;
import br.com.yunikonshine.refugiobrasil.model.domain.Language;
import br.com.yunikonshine.refugiobrasil.repository.FormationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormationService {

    private final FormationRepository formationRepository;

    public void update(Formation formation) throws FormationNotFoundException, NonBelongFormationException {
        formationRepository.validBelongFormationFromRefugee(formation.getId(), formation.getRefugeeId());
        formationRepository.update(formation);
    }

    public void delete(String formationId) throws FormationNotFoundException {
        formationRepository.delete(formationId);
    }

    public void save(Formation formation) {
        formationRepository.save(formation);
    }
}
