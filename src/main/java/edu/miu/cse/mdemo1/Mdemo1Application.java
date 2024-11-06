package edu.miu.cse.mdemo1;

import edu.miu.cse.mdemo1.model.Account;
import edu.miu.cse.mdemo1.model.User;
import edu.miu.cse.mdemo1.service.AccountServce;
import edu.miu.cse.mdemo1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class Mdemo1Application {

    private final UserService userService;
    private final AccountServce accountServce;

    public static void main(String[] args) {
        SpringApplication.run(Mdemo1Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            accountServce.deleteAllAccounts();
            userService.deleteAllUsers();
            //1. Create users, but do not save them before saving their associated Account objects
            User user1 = new User("username1", "pwd1");
            User user2 = new User("username2", "pwd2");

            Account account1 = new Account(1234, "checking");
            Account account2 = new Account(5678, "checking");

            //2. Save Account objects
            accountServce.addNewAccount(account1);
            accountServce.addNewAccount(account2);

            //3. Now, set Account objects for a user
            user1.setAccounts(List.of(accountServce.getAccount(1234).get(), account2));

            //4. Save User object
            userService.addNewUser(user1);

            //5. Display all Account objects
            System.out.println(accountServce.getAllAccounts());
            System.out.println(userService.getAllUsers());

            //6. Update User
            userService.updateUser("username1", new User("username11", "pwd01"));
            //7. Update Account
            accountServce.updateAccount(1234, new Account(12345, "checking social"));

            System.out.println("After Update: ");
            System.out.println(accountServce.getAllAccounts());
            System.out.println(userService.getAllUsers());

            //8. Delete Account
//            System.out.println("After deleting an Account: ");
//            accountServce.deleteAccount(12345);
//
//            System.out.println(accountServce.getAllAccounts());
//            System.out.println(userService.getAllUsers());


            System.out.println("After deleting a user: ");
            //First delete the associated Account object explicitly
            userService.findByUsername("username11")
                    .ifPresent(user -> {
                        for (Account account : user.getAccounts()) {
                            accountServce.deleteAccount(account.getAccountNumber());
                        }
                    });
            userService.deleteUserByUsername("username11");

            System.out.println(accountServce.getAllAccounts());
            System.out.println(userService.getAllUsers());
        };
    }

}
