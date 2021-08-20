package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.enumerable.HomeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = Address.TABLE_NAME)
public class Address {

	public static final String TABLE_NAME = "addresses";

	@DynamoDBHashKey
	private Long id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	private String street;

	private Integer number;

	private String complement;

	private String cep;

	private Integer cityId;

	@DynamoDBIgnore
	private City city;

	private HomeType homeType;

}
