package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.example.domain.exception.NotAllowedException;
import org.example.domain.port.PasswordEncoder;
import org.example.domain.port.UserRepository;

import java.util.Objects;

@RequiredArgsConstructor
public class LoginUser {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  public User login(final String email, final String password) {
    User user = userRepository.findByEmail(email).orElseThrow(() -> new NotAllowedException("user " + email + " does not exist"));
    String hashedPassword = passwordEncoder.encode(email + password);
    if(!Objects.equals(user.getPassword(), hashedPassword)){
      throw new NotAllowedException("wrong password");
    }
    return user;
  }
}
