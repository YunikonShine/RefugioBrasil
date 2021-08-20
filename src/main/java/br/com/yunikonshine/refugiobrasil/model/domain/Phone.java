package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.enumerable.PhoneType;
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
@DynamoDBTable(tableName = Phone.TABLE_NAME)
public class Phone {

	public static final String TABLE_NAME = "phones";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	@DynamoDBTypeConvertedEnum
	private PhoneType type;

	private String idd;

	private String number;

}
