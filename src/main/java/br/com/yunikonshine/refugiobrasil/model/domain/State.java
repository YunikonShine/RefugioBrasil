package br.com.yunikonshine.refugiobrasil.model.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
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
@DynamoDBTable(tableName = State.TABLE_NAME)
public class State {

    public static final String TABLE_NAME = "states";

    @DynamoDBHashKey
    private String id;

    @DynamoDBRangeKey
    private String name;

    @DynamoDBTypeConvertedEnum
    private String initials;

}
