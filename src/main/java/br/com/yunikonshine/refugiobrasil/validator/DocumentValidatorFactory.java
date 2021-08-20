package br.com.yunikonshine.refugiobrasil.validator;

import br.com.yunikonshine.refugiobrasil.exception.DocumentValidatorNotFoundException;
import br.com.yunikonshine.refugiobrasil.model.enumerable.DocumentType;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentValidatorFactory {

    private final ApplicationContext applicationContext;

    public DocumentValidator getValidator(DocumentType documentType) {
        String type = documentType.toString();
        if(applicationContext.containsBean(type) && applicationContext.isTypeMatch(type, DocumentValidator.class)) {
            return applicationContext.getBean(type, DocumentValidator.class);
        }
        throw new DocumentValidatorNotFoundException();
    }

}
