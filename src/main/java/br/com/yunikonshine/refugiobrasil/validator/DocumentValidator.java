package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;

public interface DocumentValidator {

    void isValid(String document) throws DocumentNotValidException;

}
