package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(PisValidator.PIS)
public class PisValidator implements DocumentValidator {

    protected static final String PIS = "PIS";

    private final Integer LENGTH = 11;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(PIS);
        }
    }

}
