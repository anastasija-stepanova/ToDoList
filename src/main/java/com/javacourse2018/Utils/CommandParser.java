package com.javacourse2018.Utils;

import com.javacourse2018.entity.Status;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
  public class TwoParams {
    public String param1;
    public String param2;
  }

  public class FourParams {
    public String param1;
    public String param2;
    public String param3;
    public Status param4;
  }

  public TwoParams initTwoParamsByString(String params) throws IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(params);

    TwoParams resultParams = new TwoParams();
    if (m.matches()) {
      resultParams.param1 = m.group(1);
      resultParams.param2 = m.group(2);
    } else {
      throw new IllegalArgumentException("Invalid command format: " + params);
    }

    return resultParams;
  }

  public FourParams initFourParamsByString(String params) throws IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(params);

    FourParams resultParams = new FourParams();
    if (m.matches()) {
      resultParams.param1 = m.group(1);
      resultParams.param2 = m.group(2);
      resultParams.param3 = m.group(3);
      resultParams.param3 = m.group(4);
    } else {
      throw new IllegalArgumentException("Invalid command format: " + params);
    }

    return resultParams;
  }
}
