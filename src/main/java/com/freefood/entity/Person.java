package com.freefood.entity;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Person {

  private Integer id;
  private String name;
  @OneToOne
  private Account account;
  @OneToMany(mappedBy="person")
  private List<Order> orders;
}
