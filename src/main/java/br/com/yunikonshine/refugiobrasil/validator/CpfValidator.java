package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentNotValidException;
import org.springframework.stereotype.Component;

@Component(CpfValidator.CPF)
public class CpfValidator implements DocumentValidator {

    protected static final String CPF = "CPF";

    private final Integer LENGTH = 11;

    private final String ALL_EQUALS = "^(.)\\1*$";

    private final String SEQUENTIAL = "01234567890";

    private final Character ZERO = '0';

    @Override
    public void isValid(String document) throws DocumentNotValidException {
        if (document.length() != LENGTH ||
                document.matches(ALL_EQUALS) ||
                document.equals(SEQUENTIAL) ||
                verifier(document, 10) != document.charAt(9) ||
                verifier(document, 11) != document.charAt(10)) {
            throw new DocumentNotValidException(CPF);
        }
    }

    private Character verifier(String cpf, Integer charAt) {
        Integer sum = 0;
        Integer result = 0;

        Integer total = (9 + (charAt % 10));

        for (Integer i = 0; i < total; i++) {
            sum += (Integer.parseInt(String.valueOf(cpf.charAt(i))) * charAt);
            charAt--;
        }

        result = 11 - (sum % 11);
        result -= (charAt % 10) == 1 ? 0 : 2;

        if ((result == 10) || (result == 11)) {
            return ZERO;
        }

        return String.valueOf(result).charAt(0);
    }

}
