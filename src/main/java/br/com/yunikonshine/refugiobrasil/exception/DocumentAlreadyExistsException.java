package br.com.yunikonshine.refugiobrasil.exception;

public class DocumentAlreadyExistsException extends Exception {

    public DocumentAlreadyExistsException() {
        super("Document already exists");
    }

}
