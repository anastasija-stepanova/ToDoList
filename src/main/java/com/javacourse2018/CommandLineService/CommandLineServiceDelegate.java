package com.javacourse2018.CommandLineService;

import com.javacourse2018.Entity.Status;

public interface CommandLineServiceDelegate {
  void updateDeal(String listName, String dealName, String newName, Status status);
  void print();
  void addDeal(String listName, String dealName);
  void removeDeal(String listName, String dealName);
  void printListTitles();
  void printList(String listName);
  void add(String listName);
  void remove(String listName);
  void exit();
  void save(String path);
  void load(String path);
}
