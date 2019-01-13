package com.javacourse2018.Utils;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.Status;
import com.javacourse2018.Service.DealListInteractorInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CommandParserTest {
  private static List<DealListInteractorInterface> arrayOfDealList = new ArrayList<>();

  @Test
  public void parseRawCommandAdd() {
    runCommand("add \"чихнуть\"");
    runCommand("add \"чихнуть 1\"");
  }

  @Test
  public void parseRawCommandRemove() {
    runCommand("remove \"чихнуть 1\"");
  }

  @Test
  public void parseRawCommandAddDeal() {
    runCommand("add_deal \"чихнуть\" \"заварить чай\"");
    runCommand("add_deal \"чихнуть\" \"заварить чай 1\"");
  }

  @Test
  public void parseRawCommandRemoveDeal() {
    runCommand("remove_deal \"чихнуть\" \"заварить чай 1\"");
  }

  @Test
  public void parseRawCommandUpdateDeal() {
    runCommand("update_deal \"чихнуть\" \"заварить чай\" \"выкинуть чай\" \"DONE\"");
  }

  @Test
  public void parseRawCommandPrintListTitles() {
    runCommand("print_list_titles");
  }

  @Test
  public void parseRawCommandPrintList() {
    runCommand("print_list \"чихнуть\"");
  }

  @Test
  public void parseRawCommandLoad() {
    runCommand("load \"in.json\"");
  }

  @Test
  public void parseRawCommandSave() {
    runCommand("save \"in.json\"");
  }

  @Test
  public void parseRawCommandPrint() {
    runCommand("print");
  }

  private void runCommand(String cmd) {
    CommandParser parser = new CommandParser();
    Command command = parser.parseRawCommand(cmd);
    Assert.assertTrue(command.route(arrayOfDealList));
  }
}