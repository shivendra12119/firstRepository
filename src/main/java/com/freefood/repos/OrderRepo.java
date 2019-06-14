package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Order;

@RepositoryRestResource(path="order",collectionResourceRel="order")
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
