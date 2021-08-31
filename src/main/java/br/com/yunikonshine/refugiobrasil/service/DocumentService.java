package br.com.yunikonshine.refugiobrasil.service;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongDocumentException;
import br.com.yunikonshine.refugiobrasil.model.mapper.DocumentMapper;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRefugeeRequest;
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

    private final DocumentMapper documentMapper;

    public void validDocument(DocumentRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(documentRequest.getType());
        documentValidator.isValid(documentRequest.getNumber());
        documentRepository.validDocument(documentRequest);
    }

    public void update(String documentId, String refugeeId, DocumentRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException, NonBelongDocumentException, DocumentNotFoundException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(documentRequest.getType());
        documentValidator.isValid(documentRequest.getNumber());
        documentRepository.validBelongDocumentFromRefugee(documentId, refugeeId);
        documentRepository.validDocumentFromRefugee(documentRequest, refugeeId);
        documentRepository.update(documentMapper.fromRequest(documentRequest, documentId, refugeeId));
    }

    public void delete(String documentId) throws DocumentNotFoundException {
        documentRepository.delete(documentId);
    }

    public void save(DocumentRefugeeRequest documentRequest) throws DocumentNotValidException, DocumentAlreadyExistsException {
        DocumentValidator documentValidator = documentValidatorFactory.getValidator(documentRequest.getType());
        documentValidator.isValid(documentRequest.getNumber());
        documentRepository.validDocument(documentRequest);
        documentRepository.save(documentMapper.fromRequest(documentRequest));
    }
}
