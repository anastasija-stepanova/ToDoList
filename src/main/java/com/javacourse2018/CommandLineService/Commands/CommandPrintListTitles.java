package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandPrintListTitles extends Command {
  public void route() {
    if (delegate == null) {
      return;
    }
    delegate.printListTitles();
  }
}
