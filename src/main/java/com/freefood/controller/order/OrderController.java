package com.freefood.controller.order;

import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freefood.entity.Dish;
import com.freefood.entity.Order;
import com.freefood.entity.SubOrder;
import com.freefood.repos.DishRepo;
import com.freefood.repos.OrderRepo;

@RestController
@RequestMapping("orderzz/")
public class OrderController {
  
  @Autowired
  DishRepo dishRepo;
  
  @Autowired
  OrderRepo orderRepo;
  
  @RequestMapping(path="menu/available",method=RequestMethod.GET)
  public List<Dish> getAvailableMenu(){
      return dishRepo.findAll();
  }
  @RequestMapping(path="{orderId}",method=RequestMethod.GET)
  public Order getOrderDetails(@PathVariable("orderId") int orderId) {
    Order order= orderRepo.getOne(orderId);
    List<SubOrder> subordrs=order.getSuborders();
    for(SubOrder s:subordrs) {
      System.out.println(s);
    }
    return order;
  }
    
}
