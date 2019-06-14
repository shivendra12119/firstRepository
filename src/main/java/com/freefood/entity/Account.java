package com.freefood.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Account {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;

  private Long balance;

  @OneToOne
  private Person accountHolder;

  @OneToMany(mappedBy = "sender")
  private List<Transaction> sent;

  @OneToMany(mappedBy = "receiver")
  private List<Transaction> received;
}
