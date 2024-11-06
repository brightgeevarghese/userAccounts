package edu.miu.cse.mdemo1.service;

import edu.miu.cse.mdemo1.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<User> addNewUser(User user);
    Optional<User> findByUsername(String username);
    Optional<User> updateUser(String userName, User user);
    void deleteAllUsers();
    Optional<List<User>> getAllUsers();
    void deleteUserByUsername(String username);
}
