package edu.miu.cse.mdemo1.service.impl;

import edu.miu.cse.mdemo1.model.Account;
import edu.miu.cse.mdemo1.repository.AccountRepository;
import edu.miu.cse.mdemo1.service.AccountServce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountServce {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> addNewAccount(Account account) {
        return Optional.of(accountRepository.save(account));
    }

    @Override
    public Optional<Account> updateAccount(Integer accountNumber, Account account) {
        Optional<Account> foundAccount = accountRepository.findByAccountNumber(accountNumber);
        if (foundAccount.isPresent()) {
            Account accountToUpdate = foundAccount.get();
            accountToUpdate.setAccountNumber(account.getAccountNumber());
            accountToUpdate.setAccountType(account.getAccountType());
            return Optional.of(accountRepository.save(accountToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Account> getAccount(Integer accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public void deleteAccount(Integer accountNumber) {
        accountRepository.findByAccountNumber(accountNumber)
                .ifPresent(accountRepository::delete);
    }

    @Override
    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }

    @Override
    public Optional<List<Account>> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return Optional.of(accounts);
    }
}
