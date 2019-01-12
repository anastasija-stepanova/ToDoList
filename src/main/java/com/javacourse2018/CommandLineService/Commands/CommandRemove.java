package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandRemove extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.remove(rawCommand.getArguments().get(0));
  }
}
