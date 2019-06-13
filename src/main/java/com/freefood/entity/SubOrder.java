package com.freefood.entity;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class SubOrder {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  private Dish dish;
  
  private Integer quantity;
  
  @ManyToOne
  @JoinColumn(name="placedOrder_id")
  private Order order;
  
  private Long amount;
}
