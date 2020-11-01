package com.freefood.controller;

import com.freefood.dao.PersonDao;
import com.freefood.dto.PersonDto;
import com.freefood.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("c/person/")
public class PersonController {
    @Autowired
    PersonDao personDao;

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Person create(@RequestBody PersonDto personDTO) {
        return personDao.create(personDTO);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public PersonDto get(@PathVariable Integer id) {
        Person person = personDao.get(id);
        return PersonDto.fromPerson(person);
    }

}
