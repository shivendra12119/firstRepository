package com.freefood.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;
import com.freefood.entity.Order;
import com.freefood.entity.SubOrder;
import com.freefood.repos.DishRepo;
import com.freefood.repos.OrderRepo;
import com.freefood.repos.PersonRepo;
import com.freefood.repos.SubOrderRepo;

@RestController
@RequestMapping("orderT/")
public class OrderAndTransactionController {

  @Autowired
  DishRepo dishRepo;

  @Autowired
  PersonRepo personRepo;

  @Autowired
  SubOrderRepo subOrderRepo;
  
  @Autowired
  OrderRepo orderRepo;

  // http://localhost:8098/orderT/print?shivendra=a&shivendra=b
  @RequestMapping(path="print",method = RequestMethod.GET)
  public void placeOrder(@RequestParam("dish") List<Integer> dishIds ,@RequestParam("quantity") List<Integer> quantities,
      @RequestParam("personId")Integer personId ) {
    if(dishIds.size()!=quantities.size())
      throw new RuntimeException("lol , Invalid parameters ");
    int size=dishIds.size();
    List<SubOrder> suborders=new ArrayList<>();
    long total=0;
    Order order=new Order();
    order.setPerson(personRepo.getOne(personId));
    order.setPlacedAt(new Date(System.currentTimeMillis()));
    orderRepo.save(order);
    
    
    
    for(int i=0;i<size;i++) {
      Dish dish=dishRepo.getOne(dishIds.get(i));
      SubOrder suborder=new SubOrder(dish, quantities.get(i),(long) dish.getPrice());
      suborders.add(suborder);
      suborder.setOrder(order);
      subOrderRepo.save(suborder);
      total+=dish.getPrice();
    }
    order.setTotalAmount(total);
    orderRepo.save(order);
    
  }
  
  
}
