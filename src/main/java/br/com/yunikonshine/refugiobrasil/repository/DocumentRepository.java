package br.com.yunikonshine.refugiobrasil.repository;

import br.com.yunikonshine.refugiobrasil.exception.DocumentAlreadyExistsException;
import br.com.yunikonshine.refugiobrasil.exception.DocumentNotFoundException;
import br.com.yunikonshine.refugiobrasil.exception.NonBelongDocumentException;
import br.com.yunikonshine.refugiobrasil.model.domain.Document;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class DocumentRepository {

    private final DynamoDBMapper dynamoDBMapper;

    private final GenericRepository genericRepository;

    public void validDocument(Document document) throws DocumentAlreadyExistsException {
        if(!getDocumentByRequest(document).isEmpty()) {
            throw new DocumentAlreadyExistsException();
        }
    }

    public void validBelongDocumentFromRefugee(String documentId, String refugeeId) throws NonBelongDocumentException, DocumentNotFoundException {
        Map<String, AttributeValue> item = genericRepository.findById(documentId, Document.TABLE_NAME)
                .orElseThrow(() -> new DocumentNotFoundException());

        Document document = dynamoDBMapper.marshallIntoObject(Document.class, item);

        if(!document.getRefugeeId().equals(refugeeId)) {
            throw new NonBelongDocumentException();
        }
    }

    public void validDocumentFromRefugee(Document document, String refugeeId) throws DocumentAlreadyExistsException {
        List<Map<String, AttributeValue>> items = getDocumentByRequest(document);

        List<Document> documents = items.stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Document.class, i))
                .collect(Collectors.toList());

        List<Document> existingDocuments = documents.stream()
                .filter(doc -> !doc.getRefugeeId().equals(refugeeId))
                .collect(Collectors.toList());

        if(!existingDocuments.isEmpty()) {
            throw new DocumentAlreadyExistsException();
        }
    }

    private List<Map<String, AttributeValue>> getDocumentByRequest(Document document) {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("number", document.getNumber());
        queryMap.put("type", document.getType().toString());

        String query = "#number = :number AND #type = :type";

        return genericRepository.getItems(queryMap, query, Document.TABLE_NAME);
    }

    public List<Document> getByRefugeeId(String refugeeId) {
        return genericRepository.findByRefugeeId(refugeeId, Document.TABLE_NAME).stream()
                .map(i -> dynamoDBMapper.marshallIntoObject(Document.class, i))
                .collect(Collectors.toList());
    }

    public void update(Document document) {
        dynamoDBMapper.save(document);
    }

    public void delete(String documentId) throws DocumentNotFoundException {
        Document document = dynamoDBMapper.marshallIntoObject(
                Document.class,
                genericRepository.findById(documentId, Document.TABLE_NAME)
                        .orElseThrow(() -> new DocumentNotFoundException()));

        dynamoDBMapper.delete(document);
    }

    public void save(Document document) {
        dynamoDBMapper.save(document);
    }
}
