package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.converter.LocalDateConverter;
import br.com.yunikonshine.refugiobrasil.model.enumerable.Gender;
import br.com.yunikonshine.refugiobrasil.model.enumerable.MaritalStatus;
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
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = Refugee.TABLE_NAME)
public class Refugee {

	public static final String TABLE_NAME = "refugees";

	@DynamoDBHashKey
	private String id;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDateTime creationDate;

	private String name;

	private String email;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate bornDate;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)
	private LocalDate arrivalDate;

	@DynamoDBTypeConvertedEnum
	private MaritalStatus maritalStatus;

	@DynamoDBTypeConvertedEnum
	private Gender gender;

	private Boolean institutionCourse;

	@DynamoDBIgnore
	private List<Document> documents;

	@DynamoDBIgnore
	private Necessity necessity;

	private Long birthCountryId;

	@DynamoDBIgnore
	private Country birthCountry;

	private Long originCountryId;

	@DynamoDBIgnore
	private Country originCountry;

	private String addressId;

	@DynamoDBIgnore
	private Address address;

	@DynamoDBIgnore
	private List<String> files;

	@DynamoDBIgnore
	private List<Profession> professions;

	@DynamoDBIgnore
	private List<Language> languages;

	@DynamoDBIgnore
	private List<Formation> formations;

	@DynamoDBIgnore
	private List<Phone> phones;

}
