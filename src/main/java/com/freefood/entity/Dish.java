package com.freefood.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Dish {
   @Id
   private int id;
   private String name;
   private int preperationTime;
   private int price;
  public Dish(String name, int preperationTime, int price) {
    this.name = name;
    this.preperationTime = preperationTime;
    this.price = price;
  }
  public Dish() {
  }
   
}
