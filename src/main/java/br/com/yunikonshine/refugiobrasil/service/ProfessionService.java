package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.NonBelongProfessionException;
import br.com.yunikonshine.refugiobrasil.exception.ProfessionNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Profession;
import br.com.yunikonshine.refugiobrasil.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfessionService {

    private final ProfessionRepository professionRepository;

    public void update(Profession profession) throws ProfessionNotFoundException, NonBelongProfessionException {
        professionRepository.validBelongProfessionFromRefugee(profession.getId(), profession.getRefugeeId());
        professionRepository.update(profession);
    }

    public void delete(String professionId) throws ProfessionNotFoundException {
        professionRepository.delete(professionId);
    }

    public void save(Profession profession) {
        professionRepository.save(profession);
    }
}
