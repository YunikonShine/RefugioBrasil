package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Situation;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
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
@DynamoDBTable(tableName = Necessity.TABLE_NAME)
public class Necessity {

	public static final String TABLE_NAME = "necessities";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	private String description;

	private Boolean food;

	private Boolean home;

	private Boolean medicine;

	@DynamoDBTypeConvertedEnum
	private Situation situation;

}
