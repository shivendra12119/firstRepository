package com.freefood.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;

@RestController
@RequestMapping("dish/")
public class DishController {
  @PersistenceContext
  private EntityManager em;

  @Transactional
  @RequestMapping(path = "insertData", method = RequestMethod.GET)
  public void insertData() {
    insert("ab", 10, 30);insert("cd", 5, 40);insert("ea", 0, 20);
  }
  
  @Transactional
  @RequestMapping(path = "{name}/{preperationTime}/{price}", method = RequestMethod.POST)
  public Dish insert(@PathVariable("name") String name,
      @PathVariable("preperationTime") Integer preperationTime,
      @PathVariable("price") Integer price) {
    Dish dish = new Dish(name, preperationTime, price);
    em.persist(dish);
    return dish;
  }

  @RequestMapping(path = "{id}", method = RequestMethod.GET)
  public Dish getDish(@PathVariable("id") Integer id) {
    return em.find(Dish.class, id);
  }

  @Transactional
  @RequestMapping(path = "{id}/{name}", method = RequestMethod.PUT)
  public Dish update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
    Dish dish = getDish(id);
    dish.setName(name);
    em.persist(dish);
    return getDish(id);
  }

  @Transactional
  @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
  public Boolean delete(@PathVariable("id") Integer id) {
    em.remove(getDish(id));
    return true;
  }

}
