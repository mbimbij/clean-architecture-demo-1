package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.example.domain.port.UserRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class FindUser {
  private final UserRepository userRepository;

  public Optional<User> findById(final String id){
    return userRepository.findById(id);
  }

  public List<User> findAllUsers(){
    return userRepository.findAllUsers();
  }
}
