package com.apex.crm.orm.jpa;

import com.apex.crm.orm.util.ArtifactForFramework;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Abstract super class for entities. We are assuming that early primary key
 * generation will be used.
 *
 * @param <T> the type of {@link EntityId} that will be used for this entity
 */
@MappedSuperclass
public abstract class AbstractEntity<T extends EntityId> implements Entity<T> {

  @EmbeddedId
  private T id;

  @ArtifactForFramework
  protected AbstractEntity() {}

  protected AbstractEntity(T id) {
    this.id = checkNotNull(id);
  }

  @Override
  public T getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractEntity<?> that = (AbstractEntity<?>) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return toStringHelper(this)
            .add("id", id)
            .toString();
  }
}
