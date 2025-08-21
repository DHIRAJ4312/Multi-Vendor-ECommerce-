package com.example.mv.user;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.Instant;

@Entity @Table(name="users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, unique=true) private String email;
  @Column(nullable=false) private String passwordHash;
  @Column(nullable=false) private String fullName;

  @Enumerated(EnumType.STRING) @Column(nullable=false)
  private Role role = Role.CUSTOMER;

  @CreationTimestamp private Instant createdAt;

  // getters and setters
  public Long getId() { return id; }
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }
  public String getPasswordHash() { return passwordHash; }
  public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
  public String getFullName() { return fullName; }
  public void setFullName(String fullName) { this.fullName = fullName; }
  public Role getRole() { return role; }
  public void setRole(Role role) { this.role = role; }
}
