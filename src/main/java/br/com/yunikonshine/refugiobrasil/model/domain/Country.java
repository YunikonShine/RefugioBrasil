package br.com.yunikonshine.refugiobrasil.model.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = Country.TABLE_NAME)
public class Country {

	public static final String TABLE_NAME = "countries";

	@DynamoDBHashKey
	private Long id;

	@DynamoDBRangeKey
	private String name;

}
