package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class NecessityNotFoundException extends GenericNotFoundException {

    public NecessityNotFoundException() {
        super("Necessity not found");
    }

}
