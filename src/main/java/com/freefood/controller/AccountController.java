package com.freefood.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Account;
import com.freefood.repos.AccountRepo;
import com.freefood.repos.PersonRepo;

@RestController
@RequestMapping("account/")
public class AccountController {
  
  @Autowired
  AccountRepo accountRepo;
  
  @Autowired
  PersonRepo personRepo;

  @RequestMapping(path = "create/{id}", method = RequestMethod.POST)
  public void createAccount(@PathVariable("id") int pid) {
    if (isAccountPresent(pid))
      throw new RuntimeException("Account already present");
    if (!personRepo.existsById(pid))
      throw new RuntimeException("Wrong person id");
    Account account = new Account();
    account.setAccountHolder(personRepo.getOne(pid));
    account.setBalance(0L);
    accountRepo.save(account);
  }

  private boolean isAccountPresent(int id) {
    return getAllAccountsOfPerson(id) == null ? false : true;
  }

  @RequestMapping(path = "getAccounts/{id}")
  public Account getAllAccountsOfPerson(@PathVariable("id") int pid) {
    Account accounts = accountRepo.findByAccountHolder(personRepo.getOne(pid));
    return accounts;
  }

  @RequestMapping(path = "updateBalance/{id}/{val}", method = RequestMethod.PUT)
  public void updateBalance(@PathVariable("val") int val, @PathVariable("id") int pid) {
    Account account = accountRepo.findByAccountHolder(personRepo.getOne(pid));
    long newBalance;
    if ((newBalance = account.getBalance() + val) < 0)
      throw new RuntimeException("Not enough Balance :: " + account.getBalance());
    account.setBalance(account.getBalance() + val);
    accountRepo.save(account);
  }

}
