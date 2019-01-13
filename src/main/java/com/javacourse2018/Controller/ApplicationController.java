package com.javacourse2018.Controller;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Service.DealListInteractorInterface;
import com.javacourse2018.Service.Loader;
import com.javacourse2018.Utils.CommandParser;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {
  private static final String jsonFilePath = "C:/Users/Anastasia/Jsons/default.json";

  private List<DealListInteractorInterface> arrayOfDealList;

  public ApplicationController() {
    this.arrayOfDealList = new ArrayList<>();
  }

  public void nextCommand(String commandLine) {
    CommandParser parser = new CommandParser();
    Command command = parser.parseRawCommand(commandLine);
    command.route(this.arrayOfDealList);
    this.save();
  }

  public boolean printManual() {
    System.out.println("add \"listName\"");
    System.out.println("remove \"listName\"");
    System.out.println("add_deal \"listName\" \"dealName\"");
    System.out.println("remove_deal \"listName\" \"dealName\"");
    System.out.println("update_deal \"listName\" \"dealName\" \"newDealName\" \"status\"");
    System.out.println("print");
    System.out.println("print_list \"listName\"");
    System.out.println("print_list_titles \"listName\"");
    System.out.println("load \"" + jsonFilePath + "\"");
    System.out.println("exit");
    return true;
  }

  private void save() {
    System.out.println("Syncing...");
    if (this.arrayOfDealList.isEmpty()) {
      System.out.println("List is empty. Auto save was canceled");
      return;
    }
    List<DealList> lists = new ArrayList<>();
    for (DealListInteractorInterface deals: arrayOfDealList) {
      lists.add(deals.getDeals());
    }

    Loader loader = new Loader();
    loader.save(jsonFilePath, lists);
    System.out.println("Synchronized");
  }
}