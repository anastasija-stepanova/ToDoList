package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Utils.CommandParser;
import com.javacourse2018.entity.Status;

public class CommandUpdateDeal extends Command {

  private CommandParser commandParser = new CommandParser();
  private CommandParser.FourParams params = commandParser.initFourParamsByString(parameters);

  public void route() {
    if (delegate != null) {
      delegate.updateDeal(params.param1, params.param2, params.param3, params.param4);
    }
  }
}
