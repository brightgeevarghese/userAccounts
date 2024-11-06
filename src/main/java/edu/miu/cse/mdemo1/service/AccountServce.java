package edu.miu.cse.mdemo1.service;

import edu.miu.cse.mdemo1.model.Account;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountServce {
    public Optional<Account> addNewAccount(Account account);
    public Optional<Account> updateAccount(Integer accountNumber, Account account);
    public Optional<Account> getAccount(Integer accountNumber);
    public void deleteAccount(Integer accountNumber);
    void deleteAllAccounts();
    Optional<List<Account>> getAllAccounts();
}