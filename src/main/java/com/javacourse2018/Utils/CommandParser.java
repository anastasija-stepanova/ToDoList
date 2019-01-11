package com.javacourse2018.Utils;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.CommandLineService.Commands.*;
import com.javacourse2018.entity.CommandName;
import com.javacourse2018.entity.RawCommand;
import com.javacourse2018.entity.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
  public Command parseRawCommand(String command) throws  IllegalArgumentException {
    Pattern p = Pattern.compile("([\\w]*)\\s*(.*)");
    Matcher m = p.matcher(command);

    RawCommand resultCommand = new RawCommand();
    if (m.matches()) {
      String rawCommandName = m.group(1).toLowerCase();
      CommandName commandName = CommandName.fromString(rawCommandName);
      if (commandName == null) {
        throw new IllegalArgumentException("Invalid command format: " + rawCommandName);
      }
      String rawParams = m.group(2);
      return parseCommandByNameAndParams(commandName, rawParams);
    } else {
      throw new IllegalArgumentException("Invalid command format");
    }
  }

  private Command parseCommandByNameAndParams(CommandName commandName, String rawParams) throws IllegalArgumentException {
    RawCommand rawCommand = new RawCommand();
    Command cmd;
    List<String> params = getParamsOfCommand(rawParams);
    rawCommand.setCommandName(commandName);
    rawCommand.setArguments(params);
    if (params.size() != commandName.getParamsCount()) {
      throw new IllegalArgumentException("Incorrect arguments command for: " + commandName.toString());
    }

    switch (commandName) {
      case ADD:
        cmd = new CommandAdd();
        break;
      case PRINT:
        cmd = new CommandPrint();
        break;
      case PRINT_LIST:
        cmd = new CommandPrintList();
        break;
      case PRINT_LIST_TITLES:
        cmd = new CommandPrintListTitles();
        break;
      case REMOVE:
        cmd = new CommandRemove();
        break;
      case ADD_DEAL:
        cmd = new CommandAddDeal();
        break;
      case REMOVE_DEAL:
        cmd = new CommandRemoveDeal();
        break;
      case UPDATE_DEAL:
        // Проверить статус для правильного значения в роутинге
        Status status = Status.fromString(params.get(3));
        if (status == null) {
          throw new IllegalArgumentException("Wrong status for: " + commandName.toString());
        }
        cmd = new CommandUpdateDeal();
        break;
      case EXIT:
        cmd = new CommandExit();
        break;
      case SAVE:
        cmd = new CommandSave();
        break;
      case LOAD:
        cmd = new CommandLoad();
        break;
      default:
        throw new IllegalArgumentException("Unsupported command: " + commandName.toString());
    }

    cmd.setRawCommand(rawCommand);
    return cmd;
  }

  private List<String> getParamsOfCommand(String rawParams) {
    Pattern p = Pattern.compile("\"([^\"]*)\"");
    Matcher m = p.matcher(rawParams);

    List<String> params = new ArrayList<>();

    while (m.find()) {
      params.add(m.group(1));
    }

    return params;
  }
}
