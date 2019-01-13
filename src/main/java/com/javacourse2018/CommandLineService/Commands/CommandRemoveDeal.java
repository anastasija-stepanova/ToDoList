package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandRemoveDeal extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String listName = rawCommand.getArguments().get(0);
    String dealName = rawCommand.getArguments().get(1);

    for (DealListInteractorInterface element: list) {
      if (element.getDeals().getTitle().equals(listName)) {
        element.removeDeal(dealName);
        return true;
      }
    }
    System.out.println("No such deal");
    return false;
  }
}
