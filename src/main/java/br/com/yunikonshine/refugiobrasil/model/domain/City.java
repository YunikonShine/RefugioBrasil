package br.com.yunikonshine.refugiobrasil.model.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = City.TABLE_NAME)
public class City {

	public static final String TABLE_NAME = "city";

	@DynamoDBHashKey
	private Long id;

	private String name;

	@DynamoDBAttribute(attributeName = "state_id")
	private Long stateId;

	private State state;

}
