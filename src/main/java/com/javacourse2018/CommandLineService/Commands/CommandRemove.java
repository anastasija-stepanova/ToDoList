package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandRemove extends Command {
  public void route() {
    /* парсинг ... */
    if (delegate != null) {
      delegate.remove("name");
    }
  }
}
