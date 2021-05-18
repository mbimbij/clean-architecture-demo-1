package org.example;

import org.example.controller.InMemoryUserRepository;
import org.example.domain.port.IdGenerator;
import org.example.domain.port.PasswordEncoder;
import org.example.domain.port.UserRepository;
import org.example.password.JugIdGenerator;
import org.example.password.Sha256PasswordEncoder;
import org.example.usecase.CreateUser;
import org.example.usecase.FindUser;
import org.example.usecase.LoginUser;

public class Config {
  private final UserRepository userRepository = new InMemoryUserRepository();
  private final IdGenerator idGenerator = new JugIdGenerator();
  private final PasswordEncoder passwordEncoder = new Sha256PasswordEncoder();

  public CreateUser createUser() {
    return new CreateUser(userRepository, passwordEncoder, idGenerator);
  }

  public FindUser findUser() {
    return new FindUser(userRepository);
  }

  public LoginUser loginUser() {
    return new LoginUser(userRepository, passwordEncoder);
  }
}
