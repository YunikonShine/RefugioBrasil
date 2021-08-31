package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongDocumentException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
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

    public void validDocument(Document document) throws DocumentAlreadyExistsException, DocumentNotValidException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(document.getType());
        documentValidator.isValid(document.getNumber());
        documentRepository.validDocument(document);
    }

    public void update(Document document) throws DocumentAlreadyExistsException, DocumentNotValidException, NonBelongDocumentException, DocumentNotFoundException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(document.getType());
        documentValidator.isValid(document.getNumber());
        documentRepository.validBelongDocumentFromRefugee(document.getId(), document.getRefugeeId());
        documentRepository.validDocumentFromRefugee(document, document.getRefugeeId());
        documentRepository.update(document);
    }

    public void delete(String documentId) throws DocumentNotFoundException {
        documentRepository.delete(documentId);
    }

    public void save(Document document) throws DocumentNotValidException, DocumentAlreadyExistsException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(document.getType());
        documentValidator.isValid(document.getNumber());
        documentRepository.validDocument(document);
        documentRepository.save(document);
    }
}
