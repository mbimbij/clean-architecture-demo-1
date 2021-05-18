package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.domain.entity.User;
import org.example.usecase.CreateUser;
import org.example.usecase.FindUser;
import org.example.usecase.LoginUser;

import java.util.List;
import java.util.Optional;

@Slf4j
public class Main {
  public static void main(String[] args) {
    Config config = new Config();
    CreateUser createUser = config.createUser();
    FindUser findUser = config.findUser();
    LoginUser loginUser = config.loginUser();

    User user = User.builder()
        .email("john.doe@gmail.com")
        .password("mypassword")
        .lastName("doe")
        .firstName("john")
        .build();

    User createdUser = createUser.createUser(user);
    log.info("created user: {}", createdUser);

    Optional<User> foundUser = findUser.findById(createdUser.getId());
    log.info("found user by id: {}", foundUser);

    List<User> allUsers = findUser.findAllUsers();
    log.info("all users: {}", allUsers);

  }
}
