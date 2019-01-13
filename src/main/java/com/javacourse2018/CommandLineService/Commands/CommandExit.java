package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandExit extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    System.exit(0);
    return true;
  }
}
