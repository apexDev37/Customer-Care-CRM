package com.apex.crm.user;

import com.apex.crm.orm.jpa.AbstractEntityId;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID> {

  protected UserId() {}

  public UserId(UUID id) {
    super(id);
  }
}
