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
  private int preperationTime;
  private int price;

  public Dish(String name, int preperationTime, int price) {
    this.name = name;
    this.preperationTime = preperationTime;
    this.price = price;
  }

}
