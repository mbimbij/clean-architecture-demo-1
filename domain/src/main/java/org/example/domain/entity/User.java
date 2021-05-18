package org.example.domain.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
public class User {
  private String id;
  private String email;
  private String password;
  private String lastName;
  private String firstName;
}
