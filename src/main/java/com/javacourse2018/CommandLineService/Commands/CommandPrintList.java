package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandPrintList extends Command {
  public void route() {
    /* парсинг ... */
    if (delegate != null) {
      delegate.printList("name");
    }
  }
}
