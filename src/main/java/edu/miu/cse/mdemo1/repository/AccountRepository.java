package edu.miu.cse.mdemo1.repository;

import edu.miu.cse.mdemo1.model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepository extends MongoRepository<Account, ObjectId> {
    Optional<Account> findByAccountNumber(Integer accountNumber);
}
