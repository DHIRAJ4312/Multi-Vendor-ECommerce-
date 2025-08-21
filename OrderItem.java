package com.example.mv.order;

import com.example.mv.catalog.Product;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional=false) private Order order;
  @ManyToOne(optional=false) private Product product;
  @Column(nullable=false) private int qty;
  @Column(nullable=false) private BigDecimal price;
  public Long getId(){return id;} public Order getOrder(){return order;} public void setOrder(Order o){this.order=o;}
  public Product getProduct(){return product;} public void setProduct(Product p){this.product=p;}
  public int getQty(){return qty;} public void setQty(int q){this.qty=q;}
  public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal p){this.price=p;}
}
