package org.example.kick_task1.validator.impl;

import org.example.kick_task1.validator.IntValidator;

public class IntValidatorImpl implements IntValidator {

  @Override
  public boolean isLineValid(String line) {
    if (line == null || line.isEmpty()) {
      return false;
    }
    return !line.matches(INVALID_NUMERIC_FORMAT);
  }
}
