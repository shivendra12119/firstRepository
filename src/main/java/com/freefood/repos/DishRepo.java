package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Dish;
@RepositoryRestResource(collectionResourceRel="dish",path="dish")
public interface DishRepo extends JpaRepository<Dish, Integer> {

}
