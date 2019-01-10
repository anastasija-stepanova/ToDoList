package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandPrint extends Command {
  public void route() {
    if (delegate != null) {
      delegate.print();
    }
  }
}
