package com.javacourse2018.CommandLineService;

import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

abstract public class Command {
  protected RawCommand rawCommand;
  public abstract boolean route(List<DealListInteractorInterface> list);

  public void setRawCommand(RawCommand rawCommand) {
    this.rawCommand = rawCommand;
  }
}
