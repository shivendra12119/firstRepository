package com.freefood.dao;

import com.freefood.dto.PersonDto;
import com.freefood.entity.Person;
import com.freefood.repos.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PersonDao {
    @Autowired
    PersonRepo personRepo;

    @PersistenceContext
    private EntityManager em;

    public Person create(@RequestBody PersonDto personDTO){
        Person person = new Person();
        person.setName(personDTO.getName());
        em.persist(person);
        return person;
    }

    public Person get(Integer id) {
        return personRepo.getOne(id);
    }
}
