package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.entity.Status;

public class CommandUpdateDeal extends Command {
  public void route() {
    /* парсинг ... */
    if (delegate != null) {
      delegate.updateDeal("name", "a", "b", Status.IN_PROGRESS);
    }
  }
}
