package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Account;

@RepositoryRestResource(path="account",collectionResourceRel="account")
public interface AccountRepo extends JpaRepository<Account, Integer> {

}
