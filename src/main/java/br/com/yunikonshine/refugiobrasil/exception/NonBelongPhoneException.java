package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNonBelongException;

public class NonBelongPhoneException extends GenericNonBelongException {

    public NonBelongPhoneException() {
        super("Phone not belonging to the refugee");
    }

}
