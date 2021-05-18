package org.example.password;

import org.example.domain.port.IdGenerator;

import java.util.UUID;

public class UuidPasswordGenerator implements IdGenerator {
  @Override
  public String generate() {
    return UUID.randomUUID().toString();
  }
}
