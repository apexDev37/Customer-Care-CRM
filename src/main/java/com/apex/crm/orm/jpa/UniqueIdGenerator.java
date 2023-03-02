package com.apex.crm.orm.jpa;

public interface UniqueIdGenerator<T> {
  T getNextUniqueId();
}
