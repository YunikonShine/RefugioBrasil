package br.com.yunikonshine.refugiobrasil.model.domain;


import br.com.yunikonshine.refugiobrasil.model.enumerable.DocumentType;
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
@DynamoDBTable(tableName = Document.TABLE_NAME)
public class Document {

	public static final String TABLE_NAME = "documents";

	@DynamoDBHashKey
	private String id;

	@DynamoDBAttribute(attributeName = "refugee_id")
	private String refugeeId;

	private String number;

	@DynamoDBTypeConvertedEnum
	private DocumentType type;

}
