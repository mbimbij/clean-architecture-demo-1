package org.example.usecase;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.example.domain.exception.UserAlreadyExistsException;
import org.example.domain.port.IdGenerator;
import org.example.domain.port.PasswordEncoder;
import org.example.domain.port.UserRepository;
import org.example.usecase.validator.UserValidator;

@RequiredArgsConstructor
public class CreateUser {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final IdGenerator idGenerator;
  
  public User createUser(final User user){
    UserValidator.validateUser(user);
    if(repository.findByEmail(user.getEmail()).isPresent()){
      throw new UserAlreadyExistsException(user.getEmail());
    }
    User userToSave = User.builder()
        .id(idGenerator.generate())
        .email(user.getEmail())
        .password(passwordEncoder.encode(user.getEmail() + user.getPassword()))
        .lastName(user.getLastName())
        .firstName(user.getFirstName())
        .build();
    return repository.create(userToSave);
  }
}
