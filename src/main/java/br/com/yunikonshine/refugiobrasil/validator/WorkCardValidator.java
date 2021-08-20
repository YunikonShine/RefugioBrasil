package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(WorkCardValidator.WORK_CARD)
public class WorkCardValidator implements DocumentValidator {

    protected static final String WORK_CARD = "WORK_CARD";

    private final Integer LENGTH = 13;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(WORK_CARD);
        }
    }

}
