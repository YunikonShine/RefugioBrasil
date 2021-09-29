package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.NonBelongPhoneException;
import br.com.yunikonshine.refugiobrasil.exception.PhoneNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Phone;
import br.com.yunikonshine.refugiobrasil.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public void update(Phone phone) throws PhoneNotFoundException, NonBelongPhoneException {
        phoneRepository.validBelongPhoneFromRefugee(phone.getId(), phone.getRefugeeId());
        phoneRepository.update(phone);
    }

    public void delete(String phoneId) throws PhoneNotFoundException {
        phoneRepository.delete(phoneId);
    }

    public void save(Phone phone) {
        phoneRepository.save(phone);
    }
}
