package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.entity.User;
import org.example.dto.LoginRequest;
import org.example.dto.UserDto;
import org.example.usecase.CreateUser;
import org.example.usecase.FindUser;
import org.example.usecase.LoginUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WebRestController {

  private final FindUser findUser;
  private final CreateUser createUser;
  private final LoginUser loginUser;

  @GetMapping("/users")
  public List<UserDto> findAllUser() {
    return findUser.findAllUsers().stream()
        .map(UserDto::fromUser)
        .collect(Collectors.toList());
  }

  @PostMapping("/users")
  public UserDto createUser(@RequestBody UserDto newUserDto) {
    User newUser = User.builder()
        .email(newUserDto.getEmail())
        .firstName(newUserDto.getFirstName())
        .lastName(newUserDto.getLastName())
        .password(newUserDto.getPassword())
        .build();
    return UserDto.fromUser(createUser.createUser(newUser));
  }

  @PostMapping("/login")
  public UserDto login(@RequestBody LoginRequest loginRequest) {
    return UserDto.fromUser(loginUser.login(loginRequest.getEmail(), loginRequest.getPassword()));
  }
}
