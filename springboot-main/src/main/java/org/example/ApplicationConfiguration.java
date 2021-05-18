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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
  @Bean
  public CreateUser createUser(UserRepository userRepository, PasswordEncoder passwordEncoder, IdGenerator idGenerator) {
    return new CreateUser(userRepository, passwordEncoder, idGenerator);
  }

  @Bean
  public FindUser findUser(UserRepository userRepository) {
    return new FindUser(userRepository);
  }

  @Bean
  public LoginUser loginUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    return new LoginUser(userRepository, passwordEncoder);
  }

  @Bean
  public UserRepository userRepository() {
    return new InMemoryUserRepository();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new Sha256PasswordEncoder();
  }

  @Bean
  public IdGenerator idGenerator(){
    return new JugIdGenerator();
  }
}
