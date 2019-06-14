package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Transaction;

@RepositoryRestResource(path="transation",collectionResourceRel="transaction")
public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

}
