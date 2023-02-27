package com.apex.crm.user;

import jakarta.persistence.*;
import jakarta.annotation.Nonnull;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "crm_user")
public class User {

  @Id
  private UUID id;
  private String email;
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @Nonnull
  private Set<UserRole> roles;

  protected User() {}

  public User(UUID id,
              String email,
              String password,
              Set<UserRole> roles) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.roles = roles;
  }

  public UUID getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Set<UserRole> getRoles() {
    return roles;
  }
}
