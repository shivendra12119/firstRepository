package com.freefood.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "placedOrder")
@NoArgsConstructor
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Temporal(TemporalType.TIMESTAMP)
  private Date placedAt;
  
  @OneToMany(mappedBy = "order")
  private List<SubOrder> suborders;
  
  @ManyToOne
  @JoinColumn(name = "person_id")
  private Person person;
  
  private Long totalAmount;
}
