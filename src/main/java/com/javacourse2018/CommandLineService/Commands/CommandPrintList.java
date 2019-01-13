package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandPrintList extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String listName = rawCommand.getArguments().get(0);
    for (DealListInteractorInterface element: list) {
      if (element.getDeals().getTitle().equals(listName)) {
        for (Deal deal: element.getDeals().getDealList()) {
          System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
        }
        return true;
      }
    }
    System.out.println("No such deal");
    return false;
  }
}
