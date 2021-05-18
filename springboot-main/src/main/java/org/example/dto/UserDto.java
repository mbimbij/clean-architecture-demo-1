package org.example.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.example.domain.entity.User;

@Value
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserDto {
  String id;
  String email;
  String password;
  String lastName;
  String firstName;

  public static UserDto fromUser(User user) {
    return new UserDto(user.getId(),
        user.getEmail(),
        user.getPassword(),
        user.getLastName(),
        user.getFirstName());
  }
}
