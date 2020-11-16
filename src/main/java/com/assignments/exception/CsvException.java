package com.assignments.exception;

public class CsvException extends RuntimeException{

  public CsvException (String message, Throwable ex) {
    super(message, ex);
  }

  public CsvException (String message) {
    super(message);
  }

  public CsvException (Throwable ex) {
    super(ex);
  }
}
