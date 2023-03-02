package com.apex.crm;

import com.apex.crm.orm.jpa.InMemoryUniqueIdGenerator;
import com.apex.crm.orm.jpa.UniqueIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class CustomerCareCrmApplication {

  public static void main(String[] args) {
    SpringApplication.run(CustomerCareCrmApplication.class, args);
  }

  @Bean
  public UniqueIdGenerator<UUID> idGenerator() {
    return new InMemoryUniqueIdGenerator();
  }
}
