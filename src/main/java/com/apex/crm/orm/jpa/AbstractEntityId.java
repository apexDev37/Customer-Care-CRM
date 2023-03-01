package com.apex.crm.orm.jpa;

import com.apex.crm.orm.util.ArtifactForFramework;

import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;

@MappedSuperclass
public abstract class AbstractEntityId<T extends Serializable>
  implements Serializable {

  private T id;

  @ArtifactForFramework
  protected AbstractEntityId() {}

  protected AbstractEntityId(T id) {
    this.id = Objects.requireNonNull(id);
  }

  public T getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AbstractEntityId<?> that = (AbstractEntityId<?>) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return toStringHelper(this)
            .add("id", id)
            .toString();
  }
}
