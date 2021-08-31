package br.com.yunikonshine.refugiobrasil.exception;

public class NonBelongDocumentException extends Exception{

    public NonBelongDocumentException() {
        super("Document not belonging to the refugee");
    }

}
