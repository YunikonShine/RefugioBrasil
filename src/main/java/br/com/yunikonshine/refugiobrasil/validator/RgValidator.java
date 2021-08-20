package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(RgValidator.RG)
public class RgValidator implements DocumentValidator {

    protected static final String RG = "RG";

    private final Integer MIN_LENGTH = 5;

    private final Integer MAX_LENGTH = 15;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() < MIN_LENGTH ||
                document.length() > MAX_LENGTH) {
            throw new DocumentNotValidException(RG);
        }
    }

}
