package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Entity.Status;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandUpdateDeal extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String listName = rawCommand.getArguments().get(0);
    String dealName = rawCommand.getArguments().get(1);
    String newName =  rawCommand.getArguments().get(2);
    // Парсер уже проверил что всэ ок
    Status status = Status.fromString(rawCommand.getArguments().get(3));
    for (DealListInteractorInterface dealList: list) {
      DealList deals = dealList.getDeals();

      for (Deal deal: deals.getDealList()) {
        if (deal.getTitle().equals(dealName)) {
          if (newName != null) {
            deal.setTitle(newName);
          }
          if (status != null) {
            deal.setStatus(status);
          }
          return false;
        }
      }
      System.out.println("No such deal in " + listName);
    }
    System.out.println("No such list");
    return true;

  }
}
