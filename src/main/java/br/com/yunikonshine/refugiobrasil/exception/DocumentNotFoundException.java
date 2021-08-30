package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class DocumentNotFoundException extends GenericNotFoundException {

    public DocumentNotFoundException() {
        super("Document not found");
    }

}
