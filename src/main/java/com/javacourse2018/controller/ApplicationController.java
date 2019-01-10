package com.javacourse2018.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationController {
  private static final String PRINT = "print";


  private class Command {
    public String commandName;
    public String arguments;
  }

  public ApplicationController() {

  }

  public void process(InputStream input) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(input));

    String commandLine;
    while ((commandLine = br.readLine()) != null) {
      Command command = initCommandByString(commandLine);

      switch (command.commandName) {
        case "create":
          System.out.println("execute command create with arguments: " + command.arguments);
          break;
        case "remove":
          System.out.println("execute command remove with arguments: " + command.arguments);
          break;
        case "add":
          System.out.println("execute command add with arguments: " + command.arguments);
          break;
        case "edit":
          System.out.println("execute command edit with arguments: " + command.arguments);
          break;
        case "delete":
          System.out.println("execute command delete with arguments: " + command.arguments);
          break;
        case PRINT:
          System.out.println("execute command display");
          break;
        case "exit":
          System.exit(0);
          break;
        default:
          System.out.println("invalid command: " + command.commandName);
      }
    }
  }

  private Command initCommandByString(String commandLine) throws IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(commandLine);

    Command resultCommand = new Command();
    if (m.matches()) {
      resultCommand.commandName = m.group(1).toLowerCase();
      resultCommand.arguments = m.group(2);
    } else {
      throw new IllegalArgumentException("Invalid command format: " + commandLine);
    }

    return resultCommand;
  }
}