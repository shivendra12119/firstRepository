package com.freefood.entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class SubOrder implements Serializable{
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

  public SubOrder(Dish dish, Integer quantity, Long price) {
    super();
    this.dish = dish;
    this.quantity = quantity;
    this.amount = price*quantity;
  }

  public SubOrder() {
    super();
  }

  @Override
  public String toString() {
    return "SubOrder [id=" + id + ", dish=" + dish.getName() + ", quantity=" + quantity + ", order=" + order.getId()
        + ", amount=" + amount + "]";
  }

  
  
  
}
