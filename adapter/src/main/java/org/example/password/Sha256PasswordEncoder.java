package org.example.password;

import org.apache.commons.codec.digest.DigestUtils;
import org.example.domain.port.PasswordEncoder;

public class Sha256PasswordEncoder implements PasswordEncoder {
  @Override
  public String encode(final String passwordToEncode) {
    return DigestUtils.sha256Hex(passwordToEncode);
  }
}
