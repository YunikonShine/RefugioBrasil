package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import br.com.yunikonshine.refugiobrasil.model.request.DocumentRequest;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class DocumentRepository {

    private final AmazonDynamoDB dynamoDB;

    public void validDocument(DocumentRequest document) throws DocumentAlreadyExistsException {
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":number", new AttributeValue().withS(document.getNumber()));
        expressionAttributeValues.put(":type", new AttributeValue().withS(document.getType().toString()));

        Map<String, String> expressionAttributeKeys = new HashMap<>();
        expressionAttributeKeys.put("#number", "number");
        expressionAttributeKeys.put("#type", "type");

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(Document.TABLE_NAME)
                .withFilterExpression("#number = :number AND #type = :type")
                .withExpressionAttributeValues(expressionAttributeValues)
                .withExpressionAttributeNames(expressionAttributeKeys);

        ScanResult result = dynamoDB.scan(scanRequest);

        if(result.getItems().stream().findAny().isPresent()) {
            throw new DocumentAlreadyExistsException();
        }
    }
}
