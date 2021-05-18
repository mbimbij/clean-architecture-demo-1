package org.example.domain.port;

public interface PasswordEncoder {
  String encode(final String passwordToEncode);
}
