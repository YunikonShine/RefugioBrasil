package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.enumerable.HomeType;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedEnum;
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
	private String id;

	private String street;

	private Integer number;

	private String complement;

	private String cep;

	private Integer cityId;

	@DynamoDBTypeConvertedEnum
	private HomeType homeType;

	@DynamoDBIgnore
	private City city;

}
