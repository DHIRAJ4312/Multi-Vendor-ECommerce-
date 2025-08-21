package com.example.mv.catalog;

import com.example.mv.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.time.Instant;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(name="u_review_once", columnNames = {"product_id","user_id"}))
public class Review {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional=false) private Product product;
  @ManyToOne(optional=false) private User user;
  @Min(1) @Max(5) private int rating;
  @Column(length=1000) private String comment;
  @CreationTimestamp private Instant createdAt;

  public Long getId() { return id; }
  public Product getProduct() { return product; }
  public void setProduct(Product product) { this.product = product; }
  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
  public int getRating() { return rating; }
  public void setRating(int rating) { this.rating = rating; }
  public String getComment() { return comment; }
  public void setComment(String comment) { this.comment = comment; }
}
