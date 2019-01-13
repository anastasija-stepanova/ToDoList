package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandAddDeal extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String listName = rawCommand.getArguments().get(0);
    String dealName = rawCommand.getArguments().get(1);

    for (DealListInteractorInterface element: list) {
      if (!element.getDeals().getTitle().equals(listName)) {
        continue;
      }

      for (Deal deal: element.getDeals().getDealList()) {
        if (deal.getTitle().equals(dealName)) {
          System.out.println("Such deal already exists");
          return false;
        }
      }
      element.addDeal(dealName);
      return true;

    }
    System.out.println("No such list");
    return false;
  }
}
