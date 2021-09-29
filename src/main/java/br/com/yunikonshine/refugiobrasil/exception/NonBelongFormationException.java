package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNonBelongException;

public class NonBelongFormationException extends GenericNonBelongException {

    public NonBelongFormationException() {
        super("Formation not belonging to the refugee");
    }

}
