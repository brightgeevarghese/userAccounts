package edu.miu.cse.mdemo1.repository;

import edu.miu.cse.mdemo1.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByUsername(String username);
    void deleteByUsername(String username);
}
