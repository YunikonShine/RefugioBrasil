package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.model.request.RefugeeRequest;
import br.com.yunikonshine.refugiobrasil.repository.RefugeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RefugeeService {

    private final DocumentService documentService;

    private final RefugeeRepository refugeeRepository;

    public void saveRefugee(RefugeeRequest refugeeRequest) throws DocumentAlreadyExistsException, DocumentNotValidException {
        for (DocumentRequest document : refugeeRequest.getDocuments()) {
            documentService.validDocument(document);
        }


    }

}
