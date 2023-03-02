package com.apex.crm.user;

import com.apex.crm.orm.jpa.UniqueIdGenerator;

import java.util.UUID;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
  private final UniqueIdGenerator<UUID> generator;

  public UserRepositoryCustomImpl(UniqueIdGenerator<UUID> generator) {
    this.generator = generator;
  }

  @Override
  public UserId getNextId() {
    return new UserId(generator.getNextUniqueId());
  }
}
