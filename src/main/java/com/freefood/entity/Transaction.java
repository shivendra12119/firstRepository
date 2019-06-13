package com.freefood.entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Transaction {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  
  @ManyToOne
  private Account sender;
  
  @ManyToOne
  private Account receiver;
  
  private Long amount;
  
  private Boolean isSuccessful;
  
  @Temporal(value=TemporalType.TIMESTAMP)
  private Date time;
}
