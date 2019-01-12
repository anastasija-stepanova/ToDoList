package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandAddDeal extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.addDeal(rawCommand.getArguments().get(0), rawCommand.getArguments().get(1));
  }
}
