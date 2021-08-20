package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(ProtocolValidator.PROTOCOL)
public class ProtocolValidator implements DocumentValidator {

    protected static final String PROTOCOL = "PROTOCOL";

    private final Integer LENGTH = 17;

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH) {
            throw new DocumentNotValidException(PROTOCOL);
        }
    }

}
