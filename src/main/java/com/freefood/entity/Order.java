package com.freefood.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
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
