package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class ProfessionNotFoundException extends GenericNotFoundException {

    public ProfessionNotFoundException() {
        super("Profession not found");
    }

}
