package br.com.yunikonshine.refugiobrasil.exception;

import br.com.yunikonshine.refugiobrasil.exception.generic.GenericNotFoundException;

public class AddressNotFoundException extends GenericNotFoundException {

    public AddressNotFoundException() {
        super("Address not found");
    }

}
