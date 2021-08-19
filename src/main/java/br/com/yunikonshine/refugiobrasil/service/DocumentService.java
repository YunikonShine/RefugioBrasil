package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;

    public void validDocument(DocumentRequest documentRequest) throws DocumentAlreadyExistsException {
        documentRepository.validDocument(documentRequest);
    }
}
