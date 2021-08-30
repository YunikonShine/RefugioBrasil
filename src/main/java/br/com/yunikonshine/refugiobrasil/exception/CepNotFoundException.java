package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class CepNotFoundException extends GenericNotFoundException {

    public CepNotFoundException() {
        super("CEP not found");
    }

}
