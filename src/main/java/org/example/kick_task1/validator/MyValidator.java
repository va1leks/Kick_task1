package org.example.kick_task1.validator;

public interface MyValidator {

  String VALID_REGEX= ".*[^\\d\\s-].*|.*-\\D";

  boolean isValid(String line);
}
