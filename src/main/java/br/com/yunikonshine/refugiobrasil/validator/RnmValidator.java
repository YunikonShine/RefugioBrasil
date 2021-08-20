package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(RnmValidator.RNM)
public class RnmValidator implements DocumentValidator {

    protected static final String RNM = "RNM";

    private final Integer LENGTH = 8;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(RNM);
        }
    }

}
