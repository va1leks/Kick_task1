package org.example.kick_task1.exception;

public class IntException extends Exception {

  public IntException() {
    super();
  }

  public IntException(String message) {
    super(message);
  }

  public IntException(String message, Throwable cause) {
    super(message, cause);
  }

  public IntException(Throwable cause) {
    super(cause);
  }
}
