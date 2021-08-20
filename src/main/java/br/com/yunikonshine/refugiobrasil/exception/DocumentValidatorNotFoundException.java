package br.com.yunikonshine.refugiobrasil.exception;

public class DocumentValidatorNotFoundException extends RuntimeException {

    public DocumentValidatorNotFoundException() {
        super("Document validator not found");
    }

}
