package com.javacourse2018.CommandLineService;

import com.javacourse2018.controller.ApplicationController;

abstract public class Command {
  protected CommandLineServiceDelegate delegate;
  protected String parameters;
  protected String commandName;
  public abstract  void route();
  public void setDelegate(CommandLineServiceDelegate delegate) {
    this.delegate = delegate;
  }
}
