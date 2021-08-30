package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class FormationNotFoundException extends GenericNotFoundException {

    public FormationNotFoundException() {
        super("Formation not found");
    }

}
