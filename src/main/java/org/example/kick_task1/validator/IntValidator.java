package org.example.kick_task1.validator;

public interface IntValidator {

  String INVALID_NUMERIC_FORMAT= ".*[^\\d\\s-].*|.*-\\D";

  boolean isLineValid(String line);
}
