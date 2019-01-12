package com.javacourse2018.Controller;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.CommandLineService.CommandLineServiceDelegate;
import com.javacourse2018.Service.DealListInteractor;
import com.javacourse2018.Service.DealListInteractorInterface;
import com.javacourse2018.Service.Loader;
import com.javacourse2018.Utils.CommandParser;
import com.javacourse2018.Entity.Deal;
import com.javacourse2018.Entity.DealList;
import com.javacourse2018.Entity.Status;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController implements CommandLineServiceDelegate {
  private List<DealListInteractorInterface> arrayOfDealList;

  public ApplicationController() {
    this.arrayOfDealList = new ArrayList<>();
  }

  public void nextCommand(String commandLine) {
    CommandParser parser = new CommandParser();
    Command command = parser.parseRawCommand(commandLine);
    command.setDelegate(this);
    command.route();
  }

  public boolean updateDeal(String listName, String dealName, String newName, Status status) {
    for (DealListInteractorInterface dealList: this.arrayOfDealList) {
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

  public boolean print() {
    for (DealListInteractorInterface dealList: this.arrayOfDealList) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());

      for (Deal deal: deals.getDealList()) {
        System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
      }
    }
    return true;
  }

  public boolean addDeal(String listName, String dealName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        list.addDeal(dealName);
        return false;
      }
    }
    System.out.println("No such deal");
    return true;
  }

  public boolean removeDeal(String listName, String dealName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        list.removeDeal(dealName);
        return false;
      }
    }
    System.out.println("No such deal");
    return true;
  }

  public boolean printListTitles() {
    for (DealListInteractorInterface dealList: this.arrayOfDealList) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());
    }
    return true;
  }

  public boolean printList(String listName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        for (Deal deal: list.getDeals().getDealList()) {
          System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
        }
        return false;
      }
    }
    System.out.println("No such deal");
    return true;
  }

  public boolean add(String listName) {
    DealList dealList = new DealList();
    dealList.setTitle(listName);

    DealListInteractorInterface dealListElement = new DealListInteractor();
    dealListElement.setTitle(listName);

    this.arrayOfDealList.add(dealListElement);
    return true;
  }

  public boolean remove(String listName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        this.arrayOfDealList.remove(list);
        return false;
      }
    }
    System.out.println("No such deal");
    return true;
  }

  public boolean exit() {
    System.exit(0);
    return true;
  }

  public boolean save(String path) {
    List<DealList> list = new ArrayList<>();

    for (DealListInteractorInterface deal: arrayOfDealList) {
      list.add(deal.getDeals());
    }

    Loader loader = new Loader();
    loader.save(path, list);
    return true;
  }

  public boolean load(String path) {
    Loader loader = new Loader();
    List<DealList> dealList = loader.load(path);
    if (dealList == null) {
      System.out.println("Parsing error");
      return false;
    }
    for (DealList list: dealList) {
      DealListInteractorInterface dealListInterator = new DealListInteractor();
      dealListInterator.setDealList(list);
      this.arrayOfDealList.add(dealListInterator);
    }
    return true;
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
    System.out.println("save \"path\"");
    System.out.println("load \"path\"");
    System.out.println("exit");
    return true;
  }
}