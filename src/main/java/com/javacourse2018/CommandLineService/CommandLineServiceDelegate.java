package com.javacourse2018.CommandLineService;

import com.javacourse2018.Entity.Status;

public interface CommandLineServiceDelegate {
  boolean updateDeal(String listName, String dealName, String newName, Status status);
  boolean print();
  boolean addDeal(String listName, String dealName);
  boolean removeDeal(String listName, String dealName);
  boolean printListTitles();
  boolean printList(String listName);
  boolean add(String listName);
  boolean remove(String listName);
  boolean exit();
  boolean save(String path);
  boolean load(String path);
}
