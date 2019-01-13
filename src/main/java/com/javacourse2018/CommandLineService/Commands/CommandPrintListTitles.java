package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandPrintListTitles extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    for (DealListInteractorInterface dealList: list) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());
    }
    return true;
  }
}
