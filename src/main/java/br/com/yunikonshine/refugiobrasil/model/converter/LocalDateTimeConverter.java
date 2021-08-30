package br.com.yunikonshine.refugiobrasil.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public String convert(LocalDateTime date) {
        return date.format(FORMAT);
    }

    public LocalDateTime unconvert(String date) {
        return LocalDateTime.parse(date, FORMAT);
    }

}
