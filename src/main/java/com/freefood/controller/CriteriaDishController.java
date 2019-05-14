package com.freefood.controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;
@RestController
@RequestMapping("c/dish/")
public class CriteriaDishController {
  @PersistenceContext
  private EntityManager em;
  
  //http://localhost:8098/c/dish/instant
  @RequestMapping(path = "instant", method = RequestMethod.GET)
  public List<Dish> getInstantDishes() {
    
     CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
     
     CriteriaQuery<Dish> criteriaQuery = criteriaBuilder.createQuery(Dish.class);
     Root<Dish> dish = criteriaQuery.from(Dish.class);
     Predicate predicate = criteriaBuilder.equal(dish.get("preperationTime"), 0);
     criteriaQuery.where(predicate);
     
     return em.createQuery(criteriaQuery).getResultList();
  }
  
 
  public Integer getLowestPrice() {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Integer> criteriaQuery = criteriaBuilder.createQuery(Integer.class);
    Root<Dish> dish =criteriaQuery.from(Dish.class);
    criteriaQuery.select(criteriaBuilder.min(dish.get("price")));
    return em.createQuery(criteriaQuery).getSingleResult();
  }
  //http://localhost:8098/c/dish/lowestPrice/
  @RequestMapping(path = "lessThanPriceDishes/", method = RequestMethod.GET)
  public List<Dish> getDishesWithLessPrice() {
    Integer price = getLowestPrice();
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Dish> criteriaQuery = criteriaBuilder.createQuery(Dish.class);
    Root<Dish> dish =criteriaQuery.from(Dish.class);
    Predicate predicate = criteriaBuilder.equal(dish.get("price"), price);
    criteriaQuery.where(predicate);
    return em.createQuery(criteriaQuery).getResultList();
  }
  
//http://localhost:8098/c/dish/lessThanPrice
  @RequestMapping(path = "lessThanPrice/{price}", method = RequestMethod.GET)
  public List<Dish> getDishesWithLessPrice(@PathVariable("price") Integer price) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Dish> criteriaQuery = criteriaBuilder.createQuery(Dish.class);
    Root<Dish> dish =criteriaQuery.from(Dish.class);
    Predicate predicate = criteriaBuilder.le(dish.get("price"), price);
    criteriaQuery.where(predicate);
    return em.createQuery(criteriaQuery).getResultList();
  }

//  @Transactional
//  @RequestMapping(path = "{id}/{name}", method = RequestMethod.PUT)
//  public Dish update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
//    Dish dish = getDish(id);
//    dish.setName(name);
//    em.persist(dish);
//    return getDish(id);
//  }
//
//  @Transactional
//  @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
//  public Boolean delete(@PathVariable("id") Integer id) {
//    em.remove(getDish(id));
//    return true;
//  }

}
