package com.apex.crm.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {

  @Autowired
  private UserRepository repository;

  @Test
  public void testShouldPersistSingleUserEntity() {
    // given
    Set<UserRole> roles = new HashSet<>();
    User user = new User(
            UUID.randomUUID(),
            "alex-beck@gmail.com",
            "alex-secret-pwd",
            roles);

    // when
    User actual = repository.save(user);

    // then
    assertThat(actual).isNotNull().isInstanceOf(User.class);
    assertThat(repository.count()).isEqualTo(1L);
  }
}
