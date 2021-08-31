package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNonBelongException;

public class NonBelongDocumentException extends GenericNonBelongException {

    public NonBelongDocumentException() {
        super("Document not belonging to the refugee");
    }

}
