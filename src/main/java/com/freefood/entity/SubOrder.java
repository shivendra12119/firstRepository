package com.freefood.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SubOrder {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name="dish_id")
  private Dish dish;
  
  private Integer quantity;
  
  @ManyToOne
  @JoinColumn(name="placedOrder_id")
  private Order order;
  
  private Long amount;
}
