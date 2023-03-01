package com.apex.crm.user;

import com.apex.crm.orm.jpa.AbstractEntity;
import jakarta.persistence.*;
import jakarta.annotation.Nonnull;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "crm_user")
public class User extends AbstractEntity<UserId> {

  private String email;
  private String password;

  @ElementCollection(fetch = FetchType.EAGER)
  @Enumerated(EnumType.STRING)
  @Nonnull
  private Set<UserRole> roles;

  protected User() {}

  public User(UserId id,
              String email,
              String password,
              Set<UserRole> roles) {
    super(id);
    this.email = email;
    this.password = password;
    this.roles = roles;
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
