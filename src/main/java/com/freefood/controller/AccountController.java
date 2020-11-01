package com.freefood.controller;

import com.freefood.dao.AccountDao;
import com.freefood.dto.AccountDto;
import com.freefood.dto.PersonDto;
import com.freefood.entity.Account;
import com.freefood.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("c/account/")
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @RequestMapping(path = "{personId}", method = RequestMethod.POST)
    public Account createAccount(@PathVariable("personId") Integer personId) {
        return accountDao.save(personId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public AccountDto get(@PathVariable Integer id) {
        Account account = accountDao.get(id);
        return AccountDto.fromAccount(account);
    }
    @RequestMapping(path = "deposite/{accountId}/{amount}/", method = RequestMethod.PUT)
    public AccountDto deposite(@PathVariable("amount") Long amount, @PathVariable("accountId") Integer accountId) {
        Account account = accountDao.deposite(accountId, amount);
        return AccountDto.fromAccount(account);
    }


    @RequestMapping(path = "withdraw/{accountId}/{amount}/", method = RequestMethod.PUT)
    public AccountDto withdraw(@PathVariable("amount") Long amount, @PathVariable("accountId") Integer accountId) {
        Account account = accountDao.withdraw(accountId, amount);
        return AccountDto.fromAccount(account);
    }

}
