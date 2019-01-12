package com.javacourse2018.Utils;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.CommandLineService.CommandLineServiceDelegate;
import com.javacourse2018.Entity.Status;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandParserTest implements CommandLineServiceDelegate {
  private static String verification;

  @Test
  public void parseRawCommandPrint() {
    runCommand("print");
    Assert.assertEquals(verification, "print");
  }

  @Test
  public void parseRawCommandAdd() {
    runCommand("add \"чихнуть\"");
    Assert.assertEquals(verification, "add чихнуть");
  }

  @Test
  public void parseRawCommandRemove() {
    runCommand("remove \"чихнуть\"");
    Assert.assertEquals(verification, "remove чихнуть");
  }

  @Test
  public void parseRawCommandAddDeal() {
    runCommand("add_deal \"чихнуть\" \"заварить чай\"");
    Assert.assertEquals(verification, "add_deal чихнуть заварить чай");
  }

  @Test
  public void parseRawCommandRemoveDeal() {
    runCommand("remove_deal \"чихнуть\" \"заварить чай\"");
    Assert.assertEquals(verification, "remove_deal чихнуть заварить чай");
  }

  @Test
  public void parseRawCommandUpdateDeal() {
    runCommand("update_deal \"чихнуть\" \"заварить чай\" \"выкинуть чай\" \"DONE\"");
    Assert.assertEquals(verification, "update_deal чихнуть заварить чай выкинуть чай DONE");
  }

  @Test
  public void parseRawCommandPrintListTitles() {
    runCommand("print_list_titles");
    Assert.assertEquals(verification, "print_list_titles");
  }

  @Test
  public void parseRawCommandPrintList() {
    runCommand("print_list \"чихнуть\"");
    Assert.assertEquals(verification, "print_list чихнуть");
  }

  @Test
  public void parseRawCommandSave() {
    runCommand("save \"in.json\"");
    Assert.assertEquals(verification, "save in.json");
  }

  @Test
  public void parseRawCommandLoad() {
    runCommand("load \"in.json\"");
    Assert.assertEquals(verification, "load in.json");
  }

  @Test
  public void parseRawCommandExit() {
    runCommand("exit");
    Assert.assertEquals(verification, "exit");
  }

  private void runCommand(String cmd) {
    verification = "";
    CommandParser parser = new CommandParser();
    Command command = parser.parseRawCommand(cmd);
    command.route();
    Assert.assertEquals(verification, "");
    command.setDelegate(this);
    command.route();
  }

  public boolean updateDeal(String listName, String dealName, String newName, Status status) {
    verification = "update_deal " + listName + " " + dealName + " " + newName + " " + status.toString();
    return true;
  }

  public boolean print() {
    verification = "print";
    return true;
  }

  public boolean addDeal(String listName, String dealName) {
    verification = "add_deal " + listName + " " + dealName;
    return true;
  }

  public boolean removeDeal(String listName, String dealName) {
    verification = "remove_deal " + listName + " " + dealName;
    return true;
  }

  public boolean printListTitles() {
    verification = "print_list_titles";
    return true;
  }

  public boolean printList(String listName) {
    verification = "print_list " + listName;
    return true;
  }

  public boolean add(String listName) {
    verification = "add " + listName;
    return true;
  }

  public boolean remove(String listName) {
    verification = "remove " + listName;
    return true;
  }

  public boolean exit() {
    verification = "exit";
    return true;
  }

  public boolean save(String path) {
    verification = "save " + path;
    return true;
  }

  public boolean load(String path) {
    verification = "load " + path;
    return true;
  }
}