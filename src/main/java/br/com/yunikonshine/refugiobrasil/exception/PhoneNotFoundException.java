package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class PhoneNotFoundException extends GenericNotFoundException {

    public PhoneNotFoundException() {
        super("Phone not found");
    }

}
