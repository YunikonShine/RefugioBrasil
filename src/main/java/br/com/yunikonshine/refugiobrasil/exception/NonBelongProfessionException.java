package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNonBelongException;

public class NonBelongProfessionException extends GenericNonBelongException {

    public NonBelongProfessionException() {
        super("Profession not belonging to the refugee");
    }

}
