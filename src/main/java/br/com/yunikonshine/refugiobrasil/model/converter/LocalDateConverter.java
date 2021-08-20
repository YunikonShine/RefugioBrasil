package br.com.yunikonshine.refugiobrasil.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public String convert(LocalDate date) {
        return date.format(FORMAT);
    }

    public LocalDate unconvert(String date) {
        return LocalDate.parse(date, FORMAT);
    }

}
