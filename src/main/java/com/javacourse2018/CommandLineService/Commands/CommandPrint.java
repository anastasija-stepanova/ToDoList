package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractorInterface;

import java.util.List;

public class CommandPrint extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    for (DealListInteractorInterface dealList: list) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());

      for (Deal deal: deals.getDealList()) {
        System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
      }
    }
    return true;
  }

}
