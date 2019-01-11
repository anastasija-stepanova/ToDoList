package com.javacourse2018.controller;

import com.javacourse2018.CommandLineService.Command;
import com.javacourse2018.CommandLineService.CommandLineServiceDelegate;
import com.javacourse2018.Service.DealListInteractor;
import com.javacourse2018.Service.DealListInteractorInterface;
import com.javacourse2018.Service.Loader;
import com.javacourse2018.Utils.CommandParser;
import com.javacourse2018.entity.Deal;
import com.javacourse2018.entity.DealList;
import com.javacourse2018.entity.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicationController implements CommandLineServiceDelegate {
  private List<DealListInteractorInterface> arrayOfDealList;

  public ApplicationController() {
    this.arrayOfDealList = new ArrayList<>();
  }

  public void process(InputStream input) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(input));
    CommandParser parser = new CommandParser();
    String commandLine;
    while ((commandLine = br.readLine()) != null) {
      try {
        Command command = parser.parseRawCommand(commandLine);
        command.setDelegate(this);
        command.route();
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getLocalizedMessage());
      }

    }
  }

  public void updateDeal(String listName, String dealName, String newName, Status status) {
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
          return;
        }
      }
      System.out.println("No such deal in " + listName);
    }
    System.out.println("No such list");
  }

  public void print() {
    for (DealListInteractorInterface dealList: this.arrayOfDealList) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());

      for (Deal deal: deals.getDealList()) {
        System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
      }
    }
  }

  public void addDeal(String listName, String dealName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        list.addDeal(dealName);
        return;
      }
    }
    System.out.println("No such deal");
  }

  public void removeDeal(String listName, String dealName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        list.removeDeal(dealName);
        return;
      }
    }
    System.out.println("No such deal");
  }

  public void printListTitles() {
    for (DealListInteractorInterface dealList: this.arrayOfDealList) {
      DealList deals = dealList.getDeals();
      System.out.println("Title: " + deals.getTitle());
    }
  }

  public void printList(String listName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        for (Deal deal: list.getDeals().getDealList()) {
          System.out.println("\t Deal: " + deal.getTitle() + " " + deal.getStatus().toString());
        }
        return;
      }
    }
    System.out.println("No such deal");
  }

  public void add(String listName) {
    DealList dealList = new DealList();
    dealList.setTitle(listName);

    DealListInteractorInterface dealListElement = new DealListInteractor();
    dealListElement.setTitle(listName);

    this.arrayOfDealList.add(dealListElement);
  }

  public void remove(String listName) {
    for (DealListInteractorInterface list: this.arrayOfDealList) {
      if (list.getDeals().getTitle().equals(listName)) {
        this.arrayOfDealList.remove(list);
        return;
      }
    }
    System.out.println("No such deal");
  }

  public void exit() {
    System.exit(0);
  }

  public void save(String path) {
    List<DealList> list = new ArrayList<>();

    for (DealListInteractorInterface deal: arrayOfDealList) {
      list.add(deal.getDeals());
    }

    Loader loader = new Loader();
    loader.save(path, list);
  }

  public void load(String path) {
    Loader loader = new Loader();
    List<DealList> dealList = loader.load(path);
    if (dealList == null) {
      System.out.println("Parsing error");
      return;
    }
    for (DealList list: dealList) {
      DealListInteractorInterface dealListInterator = new DealListInteractor();
      dealListInterator.setDealList(list);
      this.arrayOfDealList.add(dealListInterator);
    }
  }
}