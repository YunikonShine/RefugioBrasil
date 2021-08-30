package br.com.yunikonshine.refugiobrasil.exception.generic;

public class GenericNotFoundException extends Exception {

    private final String message;

    public GenericNotFoundException(String message) {
        super(message);
        this.message = message;
    }

}
