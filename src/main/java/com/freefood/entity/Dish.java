package com.freefood.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Dish {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  private String name;
  
  private Integer preperationTime;
  
  private Integer price;
  
  private Integer quantity;
  
  private Boolean isAvailable;

  public Dish(String name, Integer preperationTime, Integer price) {
    this.name = name;
    this.preperationTime = preperationTime;
    this.price = price;
  }
  
  public Dish(String name, Integer preperationTime, Integer price,Integer quantity,Boolean isAvailable) {
    this.name = name;
    this.preperationTime = preperationTime;
    this.price = price;
    this.quantity=quantity;
    this.isAvailable=isAvailable;
  }

}
