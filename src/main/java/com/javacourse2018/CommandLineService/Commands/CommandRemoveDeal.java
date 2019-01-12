package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandRemoveDeal extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.removeDeal(rawCommand.getArguments().get(0), rawCommand.getArguments().get(1));
  }
}
