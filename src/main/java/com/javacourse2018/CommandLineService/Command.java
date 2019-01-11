package com.javacourse2018.CommandLineService;

import com.javacourse2018.Entity.RawCommand;

abstract public class Command {
  protected CommandLineServiceDelegate delegate;
  protected RawCommand rawCommand;
  public abstract void route();
  public void setDelegate(CommandLineServiceDelegate delegate) {
    this.delegate = delegate;
  }

  public void setRawCommand(RawCommand rawCommand) {
    this.rawCommand = rawCommand;
  }
}
