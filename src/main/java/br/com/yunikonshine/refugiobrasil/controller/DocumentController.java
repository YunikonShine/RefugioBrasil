package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongDocumentException;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRefugeeRequest;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/valid")
    public ResponseEntity validDocument(@RequestBody @Valid DocumentRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException {
        documentService.validDocument(documentRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{documentId}/{refugeeId}")
    public ResponseEntity updateDocument(@PathVariable String documentId, @PathVariable String refugeeId, @RequestBody DocumentRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException, NonBelongDocumentException, DocumentNotFoundException {
        documentService.update(documentId, refugeeId, documentRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{documentId}")
    public ResponseEntity deleteDocument(@PathVariable String documentId) throws DocumentNotFoundException {
        documentService.delete(documentId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity saveDocument(@RequestBody @Valid DocumentRefugeeRequest documentRequest) throws DocumentAlreadyExistsException, DocumentNotValidException {
        documentService.save(documentRequest);
        return ResponseEntity.ok().build();
    }

}
