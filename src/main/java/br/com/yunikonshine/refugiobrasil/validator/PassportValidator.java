package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(PassportValidator.PASSPORT)
public class PassportValidator implements DocumentValidator {

    protected static final String PASSPORT = "PASSPORT";

    private final Integer LENGTH = 8;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(PASSPORT);
        }
    }

}
