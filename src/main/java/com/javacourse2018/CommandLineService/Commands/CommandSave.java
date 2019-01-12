package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandSave extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.save(rawCommand.getArguments().get(0));
  }
}
