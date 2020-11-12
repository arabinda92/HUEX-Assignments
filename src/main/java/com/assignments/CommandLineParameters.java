package com.assignments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

/**
 * Entry point of application
 */
@SpringBootApplication
public class CommandLineParameters {

  protected  CommandLineParameters() {}

  public static void main(String[] args) {
    SpringApplication.run(CommandLineParameters.class, args);
  }

}
