package com.assignments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of application
 */
@SpringBootApplication
public class WebAPIDriverClass {

  protected WebAPIDriverClass() {}

  public static void main(String[] args) {
    SpringApplication.run(WebAPIDriverClass.class, args);
  }

}
