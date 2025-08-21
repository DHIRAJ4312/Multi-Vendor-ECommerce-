package com.example.mv.auth;

import com.example.mv.user.Role;
import com.example.mv.user.User;
import com.example.mv.user.UserRepository;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final UserRepository users;
  private final PasswordEncoder encoder;
  private final JwtService jwt;

  public AuthController(UserRepository users, PasswordEncoder encoder, JwtService jwt) {
    this.users = users; this.encoder = encoder; this.jwt = jwt;
  }

  public record RegisterDto(@Email String email, @NotBlank String password, @NotBlank String fullName, Role role) {}
  public record LoginDto(@Email String email, @NotBlank String password) {}

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterDto dto) {
    if (users.findByEmail(dto.email()).isPresent()) return ResponseEntity.badRequest().body(Map.of("message", "Email already registered"));
    User u = new User();
    u.setEmail(dto.email()); u.setFullName(dto.fullName()); u.setPasswordHash(encoder.encode(dto.password()));
    u.setRole(dto.role()==null ? Role.CUSTOMER : dto.role());
    users.save(u);
    String token = jwt.generate(u.getEmail(), Map.of("role", u.getRole().name(), "uid", u.getId()));
    return ResponseEntity.ok(Map.of("token", token, "role", u.getRole().name()));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginDto dto) {
    var u = users.findByEmail(dto.email()).orElse(null);
    if (u==null || !encoder.matches(dto.password(), u.getPasswordHash())) return ResponseEntity.status(401).body(Map.of("message","Invalid credentials"));
    String token = jwt.generate(u.getEmail(), Map.of("role", u.getRole().name(), "uid", u.getId()));
    return ResponseEntity.ok(Map.of("token", token, "role", u.getRole().name()));
  }
}
