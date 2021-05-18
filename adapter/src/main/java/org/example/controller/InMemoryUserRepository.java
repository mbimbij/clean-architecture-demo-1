package org.example.controller;

import org.example.domain.entity.User;
import org.example.domain.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {
  private final Map<String, User> inMemoryDb = new HashMap<>();

  @Override
  public Optional<User> findById(String id) {
    return Optional.ofNullable(inMemoryDb.get(id));
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return inMemoryDb.values().stream()
        .filter(user -> Objects.equals(user.getEmail(), email))
        .findFirst();
  }

  @Override
  public List<User> findAllUsers() {
    return new ArrayList<>(inMemoryDb.values());
  }

  @Override
  public User create(User userToSave) {
    inMemoryDb.put(userToSave.getId(), userToSave);
    return userToSave;
  }
}
