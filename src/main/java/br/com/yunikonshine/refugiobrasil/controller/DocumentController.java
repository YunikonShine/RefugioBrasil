package br.com.yunikonshine.refugiobrasil.controller;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import br.com.yunikonshine.refugiobrasil.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping
    public ResponseEntity validDocument(@RequestBody DocumentRequest documentRequest) throws DocumentAlreadyExistsException {
        documentService.validDocument(documentRequest);
        return ResponseEntity.ok().build();
    }

}
