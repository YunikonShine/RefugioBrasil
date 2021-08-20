package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(CnhValidator.CNH)
public class CnhValidator implements DocumentValidator {

    protected static final String CNH = "CNH";

    private final Integer LENGTH = 11;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(CNH);
        }
    }

}
