package org.example.domain.port;

public interface PasswordEncoder {
  String encode(String passwordToEncode);
}
