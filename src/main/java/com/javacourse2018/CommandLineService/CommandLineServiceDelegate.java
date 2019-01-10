package com.javacourse2018.CommandLineService;

import com.javacourse2018.entity.Status;

public interface CommandLineServiceDelegate {
  void updateDeal(String listName, String dealName, String newName, Status status);
  void printList(String listName);
  void add(String listName);
  void remove(String listName);
}
