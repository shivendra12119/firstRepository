package com.freefood.dao;

import com.freefood.entity.Account;
import com.freefood.repos.AccountRepo;
import com.freefood.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class AccountDao {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    PersonRepo personRepo;

    public Account save(Integer personId) {
        if (isAccountPresent(personId))
            throw new RuntimeException("Account already present");
        if (!personRepo.existsById(personId))
            throw new RuntimeException("Wrong person id");
        Account account = new Account();
        account.setAccountHolder(personRepo.getOne(personId));
        account.setBalance(0L);
        return accountRepo.save(account);
    }

    private boolean isAccountPresent(Integer personId) {
        return accountRepo.findByAccountHolder(personRepo.getOne(personId)) == null ? false : true;
    }

    @Transactional
    public Account deposite(Integer accountId, Long amount) {
        Optional<Account> accountOptional = accountRepo.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            long balance = account.getBalance();
            balance += amount;
            account.setBalance(balance);
            return accountRepo.save(account);
        }
        return null;
    }

    @Transactional
    public Account withdraw(Integer accountId, Long amount) {
        Optional<Account> accountOptional = accountRepo.findById(accountId);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            long balance = account.getBalance();
            balance -= amount;
            if (balance < 0) {
                throw new RuntimeException("Not enough Balance :: " + account.getBalance());
            }
            account.setBalance(balance);
            return accountRepo.save(account);
        }
        return null;
    }

    public Account get(Integer id) {
        return accountRepo.getOne(id);
    }
}
