package com.javacourse2018.entity;

import java.util.HashMap;
import java.util.Map;

public enum CommandName {
  PRINT("print"),
  PRINT_LIST("print_list"),
  PRINT_LIST_TITLES("print_list_titles"),
  ADD("add"),
  REMOVE("remove"),
  ADD_DEAL("add_deal"),
  REMOVE_DEAL("remove_deal"),
  UPDATE_DEAL("update_deal"),
  EXIT("exit");

  private final String name;

  CommandName(final String name) {
    this.name = name;
  }

  private static Map<String, CommandName> getCommandName() {
    HashMap<String, CommandName> stringToCommandName = new HashMap<>();
    stringToCommandName.put(PRINT.name, PRINT);
    stringToCommandName.put(PRINT_LIST.name, PRINT_LIST);
    stringToCommandName.put(PRINT_LIST_TITLES.name, PRINT_LIST_TITLES);
    stringToCommandName.put(ADD.name, ADD);
    stringToCommandName.put(REMOVE.name, REMOVE);
    stringToCommandName.put(ADD_DEAL.name, ADD_DEAL);
    stringToCommandName.put(REMOVE_DEAL.name, REMOVE_DEAL);
    stringToCommandName.put(UPDATE_DEAL.name, UPDATE_DEAL);
    stringToCommandName.put(EXIT.name, EXIT);
    return stringToCommandName;
  }

  private static Map<String, Integer> getCommandParamsCount() {
    HashMap<String, Integer> stringToParamsCount = new HashMap<>();
    stringToParamsCount.put(PRINT.name, 0);
    stringToParamsCount.put(PRINT_LIST.name, 1);
    stringToParamsCount.put(PRINT_LIST_TITLES.name, 0);
    stringToParamsCount.put(ADD.name, 1);
    stringToParamsCount.put(REMOVE.name, 1);
    stringToParamsCount.put(ADD_DEAL.name, 2);
    stringToParamsCount.put(REMOVE_DEAL.name, 2);
    stringToParamsCount.put(UPDATE_DEAL.name, 4);
    stringToParamsCount.put(EXIT.name, 0);
    return stringToParamsCount;
  }

  @Override
  public String toString() {
    return this.name;
  }

  public Integer getParamsCount() {
    return getCommandParamsCount().get(this.name);
  }

  public static CommandName fromString(String command) {
    return getCommandName().get(command);
  }

}
