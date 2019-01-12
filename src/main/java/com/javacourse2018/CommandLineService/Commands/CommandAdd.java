package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandAdd extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.add(rawCommand.getArguments().get(0));
  }
}
