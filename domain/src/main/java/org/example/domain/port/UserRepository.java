package org.example.domain.port;

import org.example.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
  Optional<User> findById(String id);

  Optional<User> findByEmail(String email);

  List<User> findAllUsers();

  User create(User userToSave);
}