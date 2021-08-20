package br.com.yunikonshine.refugiobrasil.model.domain;

import br.com.yunikonshine.refugiobrasil.model.enumerable.Fluency;
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
@DynamoDBTable(tableName = Language.TABLE_NAME)
public class Language {

	public static final String TABLE_NAME = "languages";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	@DynamoDBTypeConvertedEnum
	private Fluency fluency;

	private String name;

}
