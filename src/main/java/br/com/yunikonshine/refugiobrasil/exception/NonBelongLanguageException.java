package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNonBelongException;

public class NonBelongLanguageException extends GenericNonBelongException {

    public NonBelongLanguageException() {
        super("Language not belonging to the refugee");
    }

}
