package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Service.DealListInteractor;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandAdd extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String listName = rawCommand.getArguments().get(0);
    DealList dealList = new DealList();
    dealList.setTitle(listName);

    DealListInteractorInterface dealListElement = new DealListInteractor();
    dealListElement.setTitle(listName);

    for (DealListInteractorInterface element: list) {
      if (element.getDeals().getTitle().equals(listName)) {
        System.out.println("Such list already exists");
        return false;
      }
    }
    list.add(dealListElement);
    return true;
  }
}
