package com.freefood.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.freefood.entity.Person;

@RepositoryRestResource(path="person",collectionResourceRel="person")
public interface PersonRepo extends JpaRepository<Person, Integer> {

}
