package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class LanguageNotFoundException extends GenericNotFoundException {

    public LanguageNotFoundException() {
        super("Language not found");
    }

}
