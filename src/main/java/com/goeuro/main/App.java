package com.goeuro.main;

import com.goeuro.client.entity.Position;
import com.goeuro.csv.CSVGenerator;
import com.goeuro.exception.CSVGeneratorException;
import com.goeuro.exception.http.HttpResponseException;
import com.goeuro.http.GoEuroHttpClient;

/**
 * The main class of the App!
 * 
 */
public class App {
  public static void main(String[] args) throws HttpResponseException, CSVGeneratorException {
    if (args.length == 0) {
      System.err.println("You have to pass a string argument!");
      printUsage();
    } else if (args.length == 1) {
      Position[] response = new GoEuroHttpClient().get(args[0]);
      CSVGenerator.generate(response);
    } else {
      System.err.println("You have passed " + args.length + " arguments to the application!");
      printUsage();
    }
  }

  private static void printUsage() {
    System.err.println("Usage: java -jar GoEuroTest.jar <your_location>");
    System.exit(1);
  }
}
