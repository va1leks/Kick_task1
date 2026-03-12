package org.example.kick_task1.validator.impl;

import org.example.kick_task1.validator.MyValidator;

public class MyValidatorImpl implements MyValidator {

  @Override
  public boolean isValid(String line) {
    if (line == null || line.isEmpty()) {
      return false;
    }
    return !line.matches(".*[^\\d\\s-].*|.*-\\D");
  }
}
