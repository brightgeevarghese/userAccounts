package edu.miu.cse.mdemo1.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "accounts")
@Data
public class Account {
    @Id
    private ObjectId id;
    @Field("account_number")
    private Integer accountNumber;
    @Field("account_type")
    private String accountType;

    public Account(Integer accountNumber, String accountType) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

}
