package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.converter.LocalDateConverter;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = Profession.TABLE_NAME)
public class Profession {

	public static final String TABLE_NAME = "professions";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	private String description;

	private String workload;

	private String company;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate startDate;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate endDate;

	private Boolean current;

	private Boolean recommendation;

	private Long countryId;

	@DynamoDBIgnore
	private Country country;

}
