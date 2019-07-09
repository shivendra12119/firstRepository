package com.freefood.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Account;
import com.freefood.entity.Person;

@RepositoryRestResource(path="account",collectionResourceRel="account")
public interface AccountRepo extends JpaRepository<Account, Integer> {
  Account findByAccountHolder(Person accountHolder);
}
