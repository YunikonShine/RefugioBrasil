package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class DocumentRepository {

    private final GenericRepository genericRepository;

    public void validDocument(DocumentRequest document) throws DocumentAlreadyExistsException {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("number", document.getNumber());
        queryMap.put("type", document.getType().toString());

        String query = "#number = :number AND #type = :type";

        List<Map<String, AttributeValue>> items = genericRepository.getItems(queryMap, query, Document.TABLE_NAME);

        if(!items.isEmpty()) {
            throw new DocumentAlreadyExistsException();
        }
    }
}
