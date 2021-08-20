package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.repository.DocumentRepository;
import br.com.yunikonshine.refugiobrasil.validator.DocumentValidator;
import br.com.yunikonshine.refugiobrasil.validator.DocumentValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentValidatorFactory documentValidatorFactory;

    private final DocumentRepository documentRepository;

    public void validDocument(DocumentRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(documentRequest.getType());
        documentValidator.isValid(documentRequest.getNumber());
        documentRepository.validDocument(documentRequest);
    }
}
