package com.example.mv.payment;

import com.example.mv.order.Order;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity
public class Payment {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(optional=false) private Order order;
  private String provider;
  private String providerRef;
  private String status;
  @CreationTimestamp private Instant createdAt;

  public Long getId(){return id;} public Order getOrder(){return order;} public void setOrder(Order o){this.order=o;}
  public String getProvider(){return provider;} public void setProvider(String p){this.provider=p;}
  public String getProviderRef(){return providerRef;} public void setProviderRef(String r){this.providerRef=r;}
  public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
}
