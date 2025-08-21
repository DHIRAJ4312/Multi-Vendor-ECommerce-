package com.example.mv.vendor;

import com.example.mv.user.User;
import jakarta.persistence.*;

@Entity
public class Vendor {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(optional=false) private User user;
  private String storeName;
  private String description;
  private boolean approved;

  public Long getId() { return id; }
  public User getUser() { return user; }
  public void setUser(User user) { this.user = user; }
  public String getStoreName() { return storeName; }
  public void setStoreName(String storeName) { this.storeName = storeName; }
  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }
  public boolean isApproved() { return approved; }
  public void setApproved(boolean approved) { this.approved = approved; }
}
