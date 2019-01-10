package com.javacourse2018.CommandLineService;

import com.javacourse2018.entity.Status;

public interface CommandLineServiceDelegate {
  void updateDeal(String listName, String dealName, String newName, Status status);
  void print();
  void addDeal(String listName, String dealName);
  void removeDeal(String listName, String dealName);
  void printListTitles();
}
