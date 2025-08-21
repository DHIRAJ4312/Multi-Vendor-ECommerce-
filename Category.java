package com.example.mv.catalog;

import jakarta.persistence.*;

@Entity @Table(indexes = {@Index(name="idx_category_slug", columnList = "slug", unique = true)})
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable=false) private String name;
  @Column(nullable=false, unique=true) private String slug;

  public Long getId() { return id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getSlug() { return slug; }
  public void setSlug(String slug) { this.slug = slug; }
}
