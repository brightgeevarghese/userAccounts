package edu.miu.cse.mdemo1.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private ObjectId id;
    @Field("user_name")
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String username;
    @Field("user_password")
    private String password;
    @DBRef(lazy = false)
    private List<Account> accounts;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
