package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandPrintList extends Command {
  private class Params {
    private String param1;
  }

  private CommandPrintList.Params params = initParamsByString(parameters);

  public void route() {
    /* парсинг ... */
    if (delegate != null) {
      delegate.printList(params.param1);
    }
  }

  private CommandPrintList.Params initParamsByString(String params) throws IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(params);

    CommandPrintList.Params resultParams = new CommandPrintList.Params();
    if (m.matches()) {
      resultParams.param1 = m.group(1);
    } else {
      throw new IllegalArgumentException("Invalid command format: " + params);
    }

    return resultParams;
  }
}
