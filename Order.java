package com.example.mv.order;

import com.example.mv.user.User;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name="orders")
public class Order {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional=false) private User user;
  @OneToMany(mappedBy="order", cascade=CascadeType.ALL, orphanRemoval=true)
  private List<OrderItem> items = new ArrayList<>();
  @Column(nullable=false) private BigDecimal total;
  @Enumerated(EnumType.STRING) private Status status = Status.CREATED;
  public enum Status { CREATED, PAID, SHIPPED, CANCELLED }
  public Long getId(){return id;} public User getUser(){return user;} public void setUser(User u){this.user=u;}
  public List<OrderItem> getItems(){return items;} public BigDecimal getTotal(){return total;} public void setTotal(BigDecimal t){this.total=t;}
  public Status getStatus(){return status;} public void setStatus(Status s){this.status=s;}
}
