package com.freefood.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;

@RestController
@RequestMapping("cp/dish/")
public class CriterionDishController {

  @PersistenceContext
  EntityManager em;

  // http://localhost:8098/cp/dish/lessThanPrice/30
  @RequestMapping(path = "lessThanPrice/{price}", method = RequestMethod.GET)
  public List<Dish> dishWithLessPrice(@PathVariable Integer price) {
    Session s = (Session) em.getDelegate();
    Criteria cr = s.createCriteria(Dish.class);
    cr.add(Restrictions.le("price", price));
    return cr.list();
  }

  // http://localhost:8098/cp/dish/instant
  @RequestMapping(path = "instant", method = RequestMethod.GET)
  public List<Dish> getInstantDishes() {
    Session s = (Session) em.getDelegate();
    Criteria cr = s.createCriteria(Dish.class);
    cr.add(Restrictions.eq("preperationTime", 0));
    return cr.list();
  }

  public Integer getLowestPrice() {
    Session s = (Session) em.getDelegate();
    Criteria cr = s.createCriteria(Dish.class);
    cr.setProjection(Projections.min("price"));
    return (Integer) cr.uniqueResult();
  }

  // http://localhost:8098/cp/dish/lowestPrice
  @RequestMapping(path = "lowestPrice", method = RequestMethod.GET)
  public List<Dish> getLowestPriceDisher() {
    Session s = (Session) em.getDelegate();
    Criteria cr = s.createCriteria(Dish.class);
    cr.add(Restrictions.eq("price", getLowestPrice()));
    return cr.list();
  }
}
