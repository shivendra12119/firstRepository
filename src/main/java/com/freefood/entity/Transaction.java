package com.freefood.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  private Account sender;

  @ManyToOne
  private Account receiver;

  private Long amount;

  private Boolean isSuccessful;

  @Temporal(value = TemporalType.TIMESTAMP)
  private Date time;
}
