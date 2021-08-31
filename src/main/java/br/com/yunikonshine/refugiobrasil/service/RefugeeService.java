package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.CepNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.domain.Refugee;
import br.com.yunikonshine.refugiobrasil.model.mapper.DocumentMapper;
import br.com.yunikonshine.refugiobrasil.model.mapper.RefugeeMapper;
import br.com.yunikonshine.refugiobrasil.repository.RefugeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefugeeService {

    private final DocumentService documentService;

    private final CepService cepService;

    private final RefugeeRepository refugeeRepository;

    private final RefugeeMapper refugeeMapper;

    private final DocumentMapper documentMapper;

    public void saveRefugee(Refugee refugee) throws DocumentAlreadyExistsException, DocumentNotValidException, CepNotFoundException {
        for (Document document : refugee.getDocuments()) {
            documentService.validDocument(document);
        }

        cepService.getDataByCep(refugee.getAddress().getCep());

        refugeeRepository.save(refugee);

    }

    public List<Refugee> getAllRefugees() throws CepNotFoundException {
        return refugeeRepository.listRefugees();
    }

    public Refugee findById(String id) throws GenericNotFoundException {
        return refugeeRepository.findById(id);
    }

    public void update(Refugee refugee) throws GenericNotFoundException {
        refugeeRepository.update(refugee);
    }
}
