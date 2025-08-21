package com.example.mv.catalog;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import jakarta.validation.Valid;
import java.util.*;

@RestController @RequestMapping("/api/products")
public class ProductController {
  private final ProductRepository repo; private final CategoryRepository cats;
  public ProductController(ProductRepository repo, CategoryRepository cats){ this.repo=repo; this.cats=cats; }

  @GetMapping public Page<Product> list(@RequestParam Optional<String> category,
                                       @RequestParam(defaultValue="0") int page,
                                       @RequestParam(defaultValue="12") int size) {
    if (category.isPresent()) return repo.findByCategory_Slug(category.get(), PageRequest.of(page, size, Sort.by("createdAt").descending()));
    return repo.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending()));
  }

  public record ProductDto(String name, Long categoryId, String description, java.math.BigDecimal price, Integer stock) {}
  @PostMapping public Product create(@Valid @RequestBody ProductDto dto){
    var cat = cats.findById(dto.categoryId()).orElseThrow();
    Product p = new Product(); p.setCategory(cat); p.setName(dto.name()); p.setDescription(dto.description());
    p.setPrice(dto.price()); p.setStock(dto.stock()); return repo.save(p);
  }
}
