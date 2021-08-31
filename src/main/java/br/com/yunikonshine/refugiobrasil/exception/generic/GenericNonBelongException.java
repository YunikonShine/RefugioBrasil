package br.com.yunikonshine.refugiobrasil.exception.generic;

public class GenericNonBelongException extends Exception {

    private final String message;

    public GenericNonBelongException(String message) {
        super(message);
        this.message = message;
    }

}
