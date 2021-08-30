package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.converter.LocalDateConverter;
import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicLevel;
import br.com.yunikonshine.refugiobrasil.model.enumerable.AcademicStatus;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = Formation.TABLE_NAME)
public class Formation {

	public static final String TABLE_NAME = "formations";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	private String course;

	private String institution;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate startDate;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate endDate;

	@DynamoDBTypeConvertedEnum
	private AcademicLevel level;

	@DynamoDBTypeConvertedEnum
	private AcademicStatus situation;

	private Long countryId;

	@DynamoDBIgnore
	private Country country;

}
