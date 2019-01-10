package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandAddDeal extends Command {
  private class Params {
    private String param1;
    private String param2;
  }

  private Params params = initParamsByString(parameters);

  public void route() {
    if (delegate != null) {
      delegate.addDeal(params.param1, params.param2);
    }
  }

  private Params initParamsByString(String params) throws IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(params);

    Params resultParams = new Params();
    if (m.matches()) {
      resultParams.param1 = m.group(1);
      resultParams.param2 = m.group(2);
    } else {
      throw new IllegalArgumentException("Invalid command format: " + params);
    }

    return resultParams;
  }
}
