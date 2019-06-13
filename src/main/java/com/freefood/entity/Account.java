package com.freefood.entity;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

  private Integer id;
  
  private Long balance;
  
  @OneToOne
  private Person accountHolder;
  
  @OneToMany(mappedBy="sender")
  private List<Transaction> sent;
  
  @OneToMany(mappedBy="receiver")
  private List<Transaction> received;
}
