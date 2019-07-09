package com.freefood.controller.dish;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;

@RestController
@RequestMapping("hql/dish/")
public class HqlDishController {

  @PersistenceContext
  EntityManager em;
  
//  http://localhost:8098/hql/dish/instant
  @RequestMapping(path = "instant", method = RequestMethod.GET)
  public List<Dish> getInstantDishes() {
     return em.createQuery("from Dish where preperationTime=0").getResultList();
  }
  
//  http://localhost:8098/c/dish/lessThanPriceDishes
  @RequestMapping(path = "lessThanPriceDishes", method = RequestMethod.GET)
  public List<Dish> getDishesWithLessPrice() {

    return em.createQuery("select name, price from Dish where price= (select min(price) from Dish)").getResultList();
  }
  
//  http://localhost:8098/hql/dish/lessThanPrice/30
  @RequestMapping(path = "lessThanPrice/{price}", method = RequestMethod.GET)
  public List<Dish> getDishesWithLessPrice(@PathVariable("price") Integer price) {
    return em.createQuery("from Dish where price<=:price").setParameter("price", price).getResultList();
  }
  
//http://localhost:8098/hql/dish/lessThanPrice/30
@RequestMapping(path = "lessThanPrice/count", method = RequestMethod.GET)
public Integer getDishesCount() {
  BigInteger a= (BigInteger) em.createNativeQuery("select count(*) from Dish").getSingleResult();
  return a.intValue();
}

}
