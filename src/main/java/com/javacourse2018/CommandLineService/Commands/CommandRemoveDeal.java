package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Utils.CommandParser;

public class CommandRemoveDeal extends Command {

  private CommandParser commandParser = new CommandParser();
  private CommandParser.TwoParams params = commandParser.initTwoParamsByString(parameters);

  public void route() {
    if (delegate != null) {
      delegate.removeDeal(params.param1, params.param2);
    }
  }
}
