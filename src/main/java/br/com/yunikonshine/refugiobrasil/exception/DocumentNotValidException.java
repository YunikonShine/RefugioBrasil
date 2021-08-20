package br.com.yunikonshine.refugiobrasil.exception;

import lombok.Getter;

@Getter
public class DocumentNotValidException extends Exception {

    private final String message;

    public DocumentNotValidException(String document) {
        super(document + " is not valid");
        this.message = document + " is not valid";
    }

}
