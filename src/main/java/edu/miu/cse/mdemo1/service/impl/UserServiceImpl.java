package edu.miu.cse.mdemo1.service.impl;

import edu.miu.cse.mdemo1.model.User;
import edu.miu.cse.mdemo1.repository.UserRepository;
import edu.miu.cse.mdemo1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<User> addNewUser(User user) {
        return Optional.of(userRepository.save(user));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> updateUser(String userName, User user) {
        Optional<User> foundUser = findByUsername(userName);
        System.out.println(foundUser);
        if (foundUser.isPresent()) {
            User userToUpdate = foundUser.get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            return Optional.of(userRepository.save(userToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public Optional<List<User>> getAllUsers() {
        return Optional.of(userRepository.findAll());
    }

    @Override
    public void deleteUserByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

}
