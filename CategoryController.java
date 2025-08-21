package com.example.mv.catalog;

import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.*;
import jakarta.validation.Valid;
import java.util.*;

@RestController @RequestMapping("/api/categories")
public class CategoryController {
  private final CategoryRepository repo;
  public CategoryController(CategoryRepository repo){ this.repo = repo; }

  @GetMapping public Page<Category> list(@RequestParam(defaultValue="0") int page,
                                        @RequestParam(defaultValue="10") int size) {
    return repo.findAll(PageRequest.of(page, size));
  }

  @PostMapping public Category create(@Valid @RequestBody Category c){ return repo.save(c); }
}
