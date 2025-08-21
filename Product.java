package com.example.mv.catalog;

import com.example.mv.vendor.Vendor;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.math.BigDecimal;
import java.time.Instant;

@Entity @Table(indexes = {@Index(name="idx_product_name", columnList = "name")})
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional=false) private Vendor vendor;
  @ManyToOne(optional=false) private Category category;

  @Column(nullable=false) private String name;
  @Column(columnDefinition = "TEXT") private String description;
  @Column(nullable=false) private BigDecimal price;
  @Column(nullable=false) private Integer stock;

  @CreationTimestamp private Instant createdAt;

  // getters and setters
  public Long getId() { return id; }
  public Vendor getVendor() { return vendor; }
  public void setVendor(Vendor vendor) { this.vendor = vendor; }
  public Category getCategory() { return category; }
  public void setCategory(Category category) { this.category = category; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public java.math.BigDecimal getPrice() { return price; }
  public void setPrice(java.math.BigDecimal price) { this.price = price; }
  public Integer getStock() { return stock; }
  public void setStock(Integer stock) { this.stock = stock; }
}
