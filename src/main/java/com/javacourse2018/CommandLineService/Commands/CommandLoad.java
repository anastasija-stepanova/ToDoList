package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractor;
import com.javacourse2018.Service.DealListInteractorInterface;
import com.javacourse2018.Service.Loader;

import java.util.List;

public class CommandLoad extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String path = rawCommand.getArguments().get(0);
    Loader loader = new Loader();
    List<DealList> dealList = loader.load(path);
    if (dealList == null) {
      System.out.println("Parsing error");
      return false;
    }
    for (DealList element: dealList) {
      DealListInteractorInterface dealListInterator = new DealListInteractor();
      dealListInterator.setDealList(element);
      list.add(dealListInterator);
    }
    return true;
  }
}
