package com.javacourse2018.CommandLineService.Commands;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.RawCommand;
import com.javacourse2018.Service.DealListInteractorInterface;
import com.javacourse2018.Service.Loader;

import java.util.ArrayList;
import java.util.List;

public class CommandSave extends Command {
  public boolean route(List<DealListInteractorInterface> list) {
    String path = rawCommand.getArguments().get(0);
    List<DealList> element = new ArrayList<>();

    for (DealListInteractorInterface deal: list) {
      element.add(deal.getDeals());
    }

    Loader loader = new Loader();
    loader.save(path, element);
    return true;
  }
}
