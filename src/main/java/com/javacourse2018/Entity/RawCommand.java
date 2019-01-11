package com.javacourse2018.Entity;

import java.util.List;

public class RawCommand {
  private CommandName commandName;
  private List<String> arguments;

  public CommandName getCommandName() {
    return commandName;
  }

  public void setCommandName(CommandName commandName) {
    this.commandName = commandName;
  }

  public List<String> getArguments() {
    return arguments;
  }

  public void setArguments(List<String> arguments) {
    this.arguments = arguments;
  }
}
