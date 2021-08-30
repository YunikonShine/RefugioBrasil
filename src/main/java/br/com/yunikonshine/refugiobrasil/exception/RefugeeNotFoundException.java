package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class RefugeeNotFoundException extends GenericNotFoundException {

    public RefugeeNotFoundException() {
        super("Refugee not found");
    }

}
