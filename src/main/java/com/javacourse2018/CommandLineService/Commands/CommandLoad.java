package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandLoad extends Command {
  public void route() {
    if (delegate != null) {
      delegate.load(rawCommand.getArguments().get(0));
    }
  }
}
