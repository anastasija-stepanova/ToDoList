package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.entity.Status;

public class CommandUpdateDeal extends Command {
  public void route() {
    if (delegate != null) {
      // Парсер уже проверил что всэ ок
      Status status = Status.fromString(rawCommand.getArguments().get(3));
      delegate.updateDeal(rawCommand.getArguments().get(0), rawCommand.getArguments().get(1), rawCommand.getArguments().get(2), status);
    }
  }
}
