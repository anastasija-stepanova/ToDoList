package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

public class CommandAdd extends Command {
  public void route() {
    /* парсинг ... */
    if (delegate != null) {
      delegate.add("name");
    }
  }
}
